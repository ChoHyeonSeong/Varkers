package com.jhs.varkers.receiver;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/receiver")
public class ReceiverController {
    private final ReceiverService service;

    @GetMapping("/{varkId}")
    public ReceiverDTO readReceive(@PathVariable Long varkId) {
        return service.readReceivers(varkId);
    }

    @PostMapping
    public String createReceiver(@RequestBody ReceiverDTO receiver) {
        System.out.println(receiver);
        service.createReceivers(receiver);
        return "OK";
    }
}
