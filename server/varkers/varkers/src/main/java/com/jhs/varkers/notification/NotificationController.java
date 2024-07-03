package com.jhs.varkers.notification;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notify")
public class NotificationController {
    private final NotificationService notificationService;

    @GetMapping(value = "/subscribe/{accountId}",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter subscribe(@PathVariable Long accountId) {
        return notificationService.subscribe(accountId);
    }
    @GetMapping("/vark/{varkId}")
    public String sendVark(Long varkId){
        return "OK";
    }
}

