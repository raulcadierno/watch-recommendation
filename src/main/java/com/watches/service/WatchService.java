package com.watches.service;

import com.watches.model.Preferences;
import com.watches.model.Watch;
import com.watches.repository.WatchRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WatchService {

    private final WatchRepository watchRepository;

    public WatchService(WatchRepository watchRepository){
        this.watchRepository = watchRepository;
    }

    /**
     * Returns all the watchs in the db
     * @return list of Watch
     */
    public List<Watch> getAll() {
        return watchRepository.findAll();
    }

    public Optional<Watch> getWatchById(long id){
        return watchRepository.findById(id);
    }

    public Watch createWatch(Watch watch){
        return watchRepository.save(watch);
    }

    public void deleteWatch(long id){

        watchRepository.deleteById(id);
    }

    public List<Watch> searchWatch(String brand, Double minPrice, Double maxPrice){

        return watchRepository.findAll().stream()
                .filter(watch -> brand == null || watch.getBrand().equalsIgnoreCase(brand))
                .filter(watch -> minPrice == null || watch.getPrice() >= minPrice)
                .filter(watch -> maxPrice == null || watch.getPrice() <= maxPrice)
                .toList();
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
