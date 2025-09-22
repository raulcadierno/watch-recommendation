package com.watches.service;

import com.watches.model.Preferences;
import com.watches.model.Watch;
import com.watches.repository.WatchRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WatchService {

    private final WatchRepository watchRepository;

    public WatchService(WatchRepository watchRepository){
        this.watchRepository = watchRepository;
    }

    public List<Watch> getAll() {
        return watchRepository.findAll();
    }

    public Watch save(Watch watch){
        return watchRepository.save(watch);
    }

    public List<Watch> recommend(Preferences preferences) {

        return watchRepository.findAll().stream()
            .filter(watch -> preferences.getCategory() == null || watch.getCategory().equalsIgnoreCase(preferences.getCategory()))
            .filter(watch -> preferences.getBrand() == null || watch.getBrand().equalsIgnoreCase(preferences.getBrand()))
            .filter(watch -> preferences.getOrigin() == null || watch.getOrigin().equalsIgnoreCase(preferences.getOrigin()))
            .filter(watch -> preferences.getMaxPrice() == null || watch.getPrice() <= preferences.getMaxPrice())
            .toList();
    }
}
