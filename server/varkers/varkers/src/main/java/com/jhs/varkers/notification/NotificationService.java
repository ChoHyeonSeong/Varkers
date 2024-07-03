package com.jhs.varkers.notification;

import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

public interface NotificationService {
    SseEmitter subscribe(Long accountId);
    SseEmitter createEmitter(Long accountId);
    void sendToClient(Long accountId,Object data, String type);
    void sendVark(Long varkId);
}
