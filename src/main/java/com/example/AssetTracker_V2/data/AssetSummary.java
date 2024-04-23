package com.example.AssetTracker_V2.data;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AssetSummary {

    final private BigDecimal cost;

    final private BigDecimal currentValue;

    final private BigDecimal depreciationRate;

    final private LocalDate purchaseDate;

    final private String title;

    /**
     * Creates a new summary of an Asset
     *
     * @param cost                  is the cost of the asset
     * @param currentValue          is the current value of the asset
     * @param depreciationRate      is the depreciation rate of the asset
     * @param purchaseDate          is the purchase date of the asset
     * @param title                 is the title of the asset
     */
    public AssetSummary(final BigDecimal cost,
                        final BigDecimal currentValue,
                        final BigDecimal depreciationRate,
                        final LocalDate purchaseDate,
                        final String title) {
        this.currentValue = currentValue;
        this.cost = cost;
        this.depreciationRate = depreciationRate;
        this.purchaseDate = purchaseDate;
        this.title = title;
    }

    /**
     * Get the cost of the asset
     *
     * @return      the cost of the asset
     */
    public BigDecimal getCost() {
        return cost;
    }

    /**
     * Get the current value of the asset
     *
     * @return      the current value of the asset
     */
    public BigDecimal getCurrentValue() {
        return currentValue;
    }

    /**
     * Get the depreciation rate of the asset
     *
     * @return      the depreciation rate of the asset
     */
    public BigDecimal getDepreciationRate() {
        return depreciationRate;
    }

    /**
     * Get the purchase date of the asset
     *
     * @return      the purchase date of the asset
     */
    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    /**
     * Get the title of the asset
     *
     * @return      the title of the asset
     */
    public String getTitle() {
        return title;
    }
}
