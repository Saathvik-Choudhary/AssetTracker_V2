package com.example.AssetTracker_V2.persistance;

import com.example.AssetTracker_V2.domain.Asset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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

        Date startDate = new Date(); // Current date

        for (int i = 0; i < titles.length; i++) {
            // Generate random purchase date within the last year
            Date purchaseDate = getRandomPastDate(startDate);

            // Save asset with random title, value, and purchase date
            assetRepository.save(new Asset(titles[i],
                    values[i],
                    BigDecimal.TEN, // Assuming a fixed maintenance cost of 10 for simplicity
                    purchaseDate
            ));
        }
    }

    /**
     * Generate a random date in the past.
     *
     * @param endDate The latest possible date.
     * @return A random date in the past.
     */
    private Date getRandomPastDate(Date endDate) {
        Random random = new Random();
        long maxDifference = 365L * 24 * 60 * 60 * 1000; // 365 days in milliseconds
        long randomOffset = (long) (random.nextDouble() * maxDifference);
        return new Date(endDate.getTime() - randomOffset);
    }

    @Override
    public void run(String... args) throws Exception {
        populateAssets();
    }
}
