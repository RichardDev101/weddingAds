package de.neuefische.backend.controller;

import de.neuefische.backend.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ad")
public class AdController {

    @Autowired
    private AdService adService;
}
