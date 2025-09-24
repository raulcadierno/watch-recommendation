package com.watches.controller;

import com.watches.model.Preferences;
import com.watches.model.Watch;
import com.watches.service.WatchService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/watches")
public class RecomendationController {

    private final WatchService watchService;

    public RecomendationController(WatchService watchService){
        this.watchService = watchService;
    }

    @GetMapping
    public List<Watch> getAllWatches(){
        return watchService.getAll();
    }

    @PostMapping
    public Watch createWatch(@RequestBody Watch watch){
        return watchService.save(watch);
    }

    @PostMapping("/recommend")
    public List<Watch> recommendWatches(@RequestBody Preferences preferences) {
        return watchService.recommend(preferences);
    }

}
