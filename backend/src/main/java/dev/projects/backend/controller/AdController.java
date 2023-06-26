package dev.projects.backend.controller;

import dev.projects.backend.collection.Advertisement;
import dev.projects.backend.service.AdService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/ad")
public class AdController {

    private final AdService adService;

    @PostMapping()
    public Advertisement save(@RequestBody Advertisement ad){
        return adService.save(ad);
    }
    @GetMapping()
    public List<Advertisement> getAllAds(){
        return adService.getAllAds();
    }


}
