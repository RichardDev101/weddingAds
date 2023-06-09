package dev.projects.backend.controller;

import dev.projects.backend.collection.Advertisement;
import dev.projects.backend.dto.AdvertisementDTO;
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
    public Advertisement save(@RequestBody AdvertisementDTO ad){
        return adService.save(ad);
    }
    @GetMapping()
    public List<Advertisement> getAllAds(){
        return adService.getAllAds();
    }

    @GetMapping("{id}")
    public Advertisement getAdWithId(@PathVariable String id){
        return adService.getAdWithId(id);
    }

    @PutMapping("{id}")
    public Advertisement update(@RequestBody AdvertisementDTO ad, @PathVariable String id){
        return adService.updateAd(ad, id);
    }
}
