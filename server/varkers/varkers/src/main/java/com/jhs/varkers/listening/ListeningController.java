package com.jhs.varkers.listening;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/listen")
public class ListeningController {
    private final ListeningService listeningService;

    @GetMapping("/listening/{accountId}")
    public List<ListeningDTO> readListenings(@PathVariable Long accountId) {
        return listeningService.readByListeningId(accountId);
    }

    @GetMapping("/listener/{accountId}")
    public List<ListeningDTO> readListeners(@PathVariable Long accountId) {
        return listeningService.readByAccountId(accountId);
    }
}
