package com.jhs.varkers.notification;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
@RequiredArgsConstructor
public class EmitterRepository {
    private final Map<Long, SseEmitter> emitters= new ConcurrentHashMap<>();

    public void save(Long accountId, SseEmitter emitter){
        emitters.put(accountId,emitter);
    }

    public void deleteById(Long accountId){
        emitters.remove(accountId);
    }

    public SseEmitter findById(Long accountId){
        return emitters.get(accountId);
    }
}
