package com.example.AssetTracker_V2.data;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class GetAllAssetsSummaryRequest {

    private final LocalDateTime userDateTime;

    public GetAllAssetsSummaryRequest(LocalDateTime userDateTime) {
        this.userDateTime = userDateTime;
    }

    public LocalDateTime getUserDateTime() {
        return userDateTime;
    }
}
