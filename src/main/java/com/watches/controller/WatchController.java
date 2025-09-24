package com.watches.controller;

import com.watches.model.Preferences;
import com.watches.model.Watch;
import com.watches.service.WatchService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/watches")
public class WatchController {

    private final WatchService watchService;

    public WatchController(WatchService watchService){
        this.watchService = watchService;
    }

    // GET /api/watches
    @GetMapping
    public List<Watch> getAllWatches(){
        return watchService.getAll();
    }

    // POST /api/watches
    @PostMapping
    public Watch createWatch(@RequestBody Watch watch){
        return watchService.createWatch(watch);
    }

    // GET /api/watches/recommend
    @PostMapping("/recommend")
    public List<Watch> recommendWatches(@RequestBody Preferences preferences) {
        return watchService.recommend(preferences);
    }
}