package com.example.supplycraft.repositories;
import com.example.supplycraft.models.Analytics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnalyticsRepository extends JpaRepository<Analytics, Long> {

    // Custom query method to find analytics by metricName
    List<Analytics> findByMetricName(String metricName);
    
    // Additional custom query methods can be added as needed
    
}
