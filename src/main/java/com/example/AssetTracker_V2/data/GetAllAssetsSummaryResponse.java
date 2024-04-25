package com.example.AssetTracker_V2.data;

import com.example.AssetTracker_V2.common.Response;

import java.math.BigDecimal;

public class GetAllAssetsSummaryResponse extends Response {
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
