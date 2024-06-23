package com.jhs.varkers.vark;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vark")
public class VarkController {
    private final VarkService varkService;

    @PostMapping
    public String createVark(@RequestBody VarkDTO vark){
        varkService.createVark(vark);
        return "OK";
    }

    @GetMapping("/{varkId}")
    public VarkDTO readVark(@PathVariable Long varkId)
    {
        return varkService.readVark(varkId);
    }

    @GetMapping("/account/{accountId}")
    public List<VarkDTO> readVarkOfAccount(@PathVariable Long accountId)
    {
        return varkService.readVarkOfAccount(accountId);
    }

    @DeleteMapping("/{id}")
    public String deleteVark(@PathVariable Long id)
    {
        varkService.deleteVark(id);
        return "OK";
    }

    @GetMapping("/road/{accountId}")
    public List<VarkDTO> readVarkRoad(@PathVariable Long accountId){
        return varkService.readVarkRoad(accountId);
    }
}
