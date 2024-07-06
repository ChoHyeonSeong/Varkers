package com.jhs.varkers.notification;

import com.jhs.varkers.listening.ListeningDTO;
import com.jhs.varkers.listening.ListeningService;
import com.jhs.varkers.receiver.ReceiverDTO;
import com.jhs.varkers.receiver.ReceiverService;
import com.jhs.varkers.vark.VarkDTO;
import com.jhs.varkers.vark.VarkService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class NotifyServiceImpl implements NotifyService {

    private static final Long DEFAULT_TIMEOUT = 36000000L;
    private static final String SEND_CREATE_TYPE = "create";
    private final EmitterRepository emitterRepo;
    private final VarkService varkService;
    private final ListeningService listeningService;
    private final ReceiverService receiverService;

    @Override
    public SseEmitter subscribe(Long accountId) {
        SseEmitter emitter = createEmitter(accountId);

        sendToClient(accountId, "EventStream Created. [accountId="+ accountId + "]","subscribe");
        return emitter;
    }

    @Override
    public void sendToClient(Long accountId, Object data, String type) {
        SseEmitter emitter = emitterRepo.findById(accountId);
        if (emitter != null) {
            try {
                emitter.send(SseEmitter.event()
                        .id(String.valueOf(accountId))
                        .name(type)
                        .data(data)
                );

            }catch (IOException e){
                emitterRepo.deleteById(accountId);
                emitter.completeWithError(e);
            }
        }
    }

    @Override
    public SseEmitter createEmitter(Long accountId) {
        SseEmitter emitter = new SseEmitter(DEFAULT_TIMEOUT);
        emitterRepo.save(accountId, emitter);

        emitter.onCompletion(()->emitterRepo.deleteById(accountId));
        emitter.onTimeout(()->emitterRepo.deleteById(accountId));
        emitter.onError((e)->emitterRepo.deleteById(accountId));

        return emitter;
    }

    @Override
    public void sendVark(Long varkId) {
        // sse 보내기
        VarkDTO sendDTO = varkService.readVark(varkId);
        List<Long> listenerList = getListeners(receiverService.readReceivers(varkId),sendDTO.getAccountId());
        listenerList.add(sendDTO.getAccountId());
        listenerList.forEach(l-> sendToClient(l,sendDTO,SEND_CREATE_TYPE));
    }

    private List<Long> getListeners(ReceiverDTO receiver, Long ownerId) {
        List<Long> listenerList;
        if(receiver.getAccountIds().size() == 1 && !receiver.getAccountIds().get(0).equals(ownerId)){
            // 나와 상대방의 리스너 교집합에게만 보이게 만드는 로직
            // 상대방의 listener를 가져와서 set에 저장
            Set<Long> otherListeners = listeningService.readByListeningId(receiver.getAccountIds().get(0))
                    .stream()
                    .map(ListeningDTO::getAccountId)
                    .collect(Collectors.toSet());
            // 나의 listener를 가져와서 상대방의 listener set과 비교
            // List 형으로 비교하면 너무 오래걸릴 것 같아서 해시값을 쓰는 set을 활용
            listenerList = listeningService.readByListeningId(ownerId)
                    .stream()
                    .map(ListeningDTO::getAccountId)
                    .filter(otherListeners::contains)
                    .collect(Collectors.toList());
        }else{
            listenerList = listeningService.readByListeningId(ownerId)
                    .stream()
                    .map(ListeningDTO::getAccountId)
                    .collect(Collectors.toList());
        }
        return listenerList;
    }
}
