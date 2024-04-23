package com.example.AssetTracker_V2.data;

import java.math.BigDecimal;

public class GetAllAssetsSummaryResponse {
    private final BigDecimal cost;

    private final BigDecimal value;

    private final Long count;

    public GetAllAssetsSummaryResponse(final Long count,
                                       final BigDecimal cost,
                                       final BigDecimal value) {
        this.cost = cost;
        this.value = value;
        this.count = count;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public BigDecimal getValue() {
        return value;
    }

    public Long getCount() {
        return count;
    }
}
