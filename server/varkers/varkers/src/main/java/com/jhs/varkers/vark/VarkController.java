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

    @GetMapping("/{id}")
    public VarkDTO readVark(@PathVariable Long id)
    {
        return varkService.readVark(id);
    }

    @GetMapping("/account/{id}")
    public List<VarkDTO> readVarkOfAccount(@PathVariable(name = "id") Long accountId)
    {
        return varkService.readVarkOfAccount(accountId);
    }

    @DeleteMapping("/{id}")
    public String deleteVark(@PathVariable Long id)
    {
        varkService.deleteVark(id);
        return "OK";
    }
}
