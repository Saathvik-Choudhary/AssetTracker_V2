package com.example.AssetTracker_V2.persistance;

import com.example.AssetTracker_V2.domain.Asset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Random;

/**
 * A utility class to populate assets.
 */
@Repository
public class AssetPopulator implements CommandLineRunner {

    @Autowired
    AssetRepository assetRepository;

    /**
     * Populate assets with sample data.
     */
    public void populateAssets() {
        Random random = new Random();

        // Sample titles and values for assets
        String[] titles = {"Laptop", "Smartphone", "Camera", "Tablet", "Headphones", "Gaming Console", "Fitness Tracker", "Smartwatch", "Drone", "VR Headset"};
        BigDecimal[] values = {BigDecimal.valueOf(1000), BigDecimal.valueOf(800), BigDecimal.valueOf(600), BigDecimal.valueOf(400), BigDecimal.valueOf(300), BigDecimal.valueOf(400), BigDecimal.valueOf(200), BigDecimal.valueOf(300), BigDecimal.valueOf(800), BigDecimal.valueOf(500)};

        LocalDate startDate = LocalDate.of(2023, 1, 1); // Start date for purchases

        for (int i = 0; i < titles.length; i++) {
            // Generate random purchase date within the last year
            LocalDate purchaseDate = startDate.minusDays(random.nextInt(365));

            // Save asset with random title, value, and purchase date
            assetRepository.save(new Asset(titles[i],
                    values[i],
                    BigDecimal.TEN, // Assuming a fixed maintenance cost of 10 for simplicity
                    purchaseDate
            ));
        }
    }

    @Override
    public void run(String... args) throws Exception {
        populateAssets();
    }
}
