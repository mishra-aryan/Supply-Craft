package com.example.supplycraft.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.supplycraft.models.Analytics;
import com.example.supplycraft.repositories.AnalyticsRepository;

import java.util.List;

@Service
public class AnalyticsService {
    
	@Autowired
    public AnalyticsRepository analyticsRepository;


    public List<Analytics> getAllAnalytics() {
        return analyticsRepository.findAll();
    }

    public Analytics createAnalytics(Analytics analytics) {
        return analyticsRepository.save(analytics);
    }

    public Analytics getAnalyticsById(Long id) {
        return analyticsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Analytics not found with id: " + id));
    }

    public Analytics updateAnalytics(Long id, Analytics updatedAnalytics) {
        Analytics existingAnalytics = getAnalyticsById(id);
        existingAnalytics.setMetricName(updatedAnalytics.getMetricName());
        existingAnalytics.setValue(updatedAnalytics.getValue());
        return analyticsRepository.save(existingAnalytics);
    }

    public void deleteAnalytics(Long id) {
        analyticsRepository.deleteById(id);
    }
}
