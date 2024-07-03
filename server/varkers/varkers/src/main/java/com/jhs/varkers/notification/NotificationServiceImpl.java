package com.jhs.varkers.notification;

import com.jhs.varkers.listening.ListeningDTO;
import com.jhs.varkers.listening.ListeningService;
import com.jhs.varkers.vark.VarkDTO;
import com.jhs.varkers.vark.VarkService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import org.yaml.snakeyaml.emitter.Emitter;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class NotificationServiceImpl implements NotificationService {

    private static final Long DEFAULT_TIMEOUT = 36000000L;
    private static final String SEND_CREATE_TYPE = "create";
    private final EmitterRepository emitterRepo;
    private final VarkService varkService;
    private final ListeningService listeningService;

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
        // 리시버가 2명이상 넘어가면 나와 상대방의 리스너 교집합에게만 보이게 만드는 로직
        VarkDTO sendDTO = varkService.readVark(varkId);
        List<Long> listenerList = listeningService.readByListeningId(sendDTO.getAccountId())
                .stream()
                .map(ListeningDTO::getAccountId)
                .collect(Collectors.toList());
        listenerList.add(sendDTO.getAccountId());
        listenerList.forEach(l->{
            sendToClient(l,sendDTO,SEND_CREATE_TYPE);
        });
    }
}
