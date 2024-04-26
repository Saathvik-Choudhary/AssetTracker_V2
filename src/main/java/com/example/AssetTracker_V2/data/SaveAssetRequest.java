package com.example.AssetTracker_V2.data;

import com.example.AssetTracker_V2.common.Request;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

public class SaveAssetRequest extends Request {
    private final BigDecimal cost;

    private final String currency;

    private final BigDecimal depreciationRate;

    private final Date purchaseDate;

    private final String title;

    /**R
     * Constructs an AssetSummary object.
     *
     * @param cost The cost of the asset.
     * @param depreciationRate The depreciation rate of the asset.
     * @param purchaseDate The purchase date of the asset.
     * @param title The title of the asset.
     */
    public SaveAssetRequest(final String title,
                            final BigDecimal cost,
                            final String currency,
                            final BigDecimal depreciationRate,
                            final Date purchaseDate
    ) {
        this.cost = cost;
        this.currency = currency;
        this.depreciationRate = depreciationRate;
        this.purchaseDate = purchaseDate;
        this.title = title;
    }

    /**
     * Get the cost of the asset.
     *
     * @return The cost of the asset.
     */
    public BigDecimal getCost() {
        return cost;
    }

    /**
     * Get the currency of the input asset
     *
     * @return the currency of the input asset
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Get the depreciation rate of the asset.
     *
     * @return The depreciation rate of the asset.
     */
    public BigDecimal getDepreciationRate() {
        return depreciationRate;
    }

    /**
     * Get the purchase date of the asset.
     *
     * @return The purchase date of the asset.
     */
    public Date getPurchaseDate() {
        return purchaseDate;
    }

    /**
     * Get the title of the asset.
     *
     * @return The title of the asset.
     */
    public String getTitle() {
        return title;
    }
}
