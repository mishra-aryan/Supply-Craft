package com.example.supplycraft.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.supplycraft.models.Analytics;
import com.example.supplycraft.services.AnalyticsService;

@RestController
@RequestMapping("/api/analytics")
public class AnalyticsController {
    
	@Autowired
    private AnalyticsService analyticsService;

    @GetMapping
    public ResponseEntity<List<Analytics>> getAllAnalytics() {
        List<Analytics> analyticsList = analyticsService.getAllAnalytics();
        return ResponseEntity.ok(analyticsList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Analytics> getAnalyticsById(@PathVariable Long id) {
        Analytics analytics = analyticsService.getAnalyticsById(id);
        return ResponseEntity.ok(analytics);
    }

    @PostMapping
    public ResponseEntity<Analytics> createAnalytics(@RequestBody Analytics analytics) {
        Analytics createdAnalytics = analyticsService.createAnalytics(analytics);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAnalytics);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Analytics> updateAnalytics(@PathVariable Long id, @RequestBody Analytics updatedAnalytics) {
        Analytics analytics = analyticsService.updateAnalytics(id, updatedAnalytics);
        return ResponseEntity.ok(analytics);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnalytics(@PathVariable Long id) {
        analyticsService.deleteAnalytics(id);
        return ResponseEntity.noContent().build();
    }
}

