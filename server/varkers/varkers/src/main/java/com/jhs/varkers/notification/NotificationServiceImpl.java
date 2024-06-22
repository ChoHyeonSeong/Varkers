package com.jhs.varkers.notification;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import org.yaml.snakeyaml.emitter.Emitter;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private static final Long DEFAULT_TIMEOUT = 36000000L;
    private final EmitterRepository emitterRepo;

    @Override
    public SseEmitter subscribe(Long accountId) {
        SseEmitter emitter = createEmitter(accountId);
        sendToClient(accountId, "EventStream Created. [accountId="+ accountId + "]");
        return emitter;
    }

    @Override
    public void sendToClient(Long accountId, Object data) {
        SseEmitter emitter = emitterRepo.findById(accountId);
        if (emitter != null) {
            try {
                emitter.send(SseEmitter.event()
                        .id(String.valueOf(accountId))
                        .name("sse")
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

        return emitter;
    }
}
