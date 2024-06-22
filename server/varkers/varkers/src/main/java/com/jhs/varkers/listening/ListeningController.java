package com.jhs.varkers.listening;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ListeningController {

    @GetMapping
    public List<ListeningDTO> getListenings() {
        return null;
    }

    @GetMapping
    public List<ListeningDTO> getListeners() {
        return null;
    }
}
