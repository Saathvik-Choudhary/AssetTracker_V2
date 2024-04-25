package com.example.AssetTracker_V2.data;

import com.example.AssetTracker_V2.common.PaginatedRequest;
import com.example.AssetTracker_V2.common.PaginatedResponse;
import com.example.AssetTracker_V2.domain.Asset;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.domain.Page;

public class GetAllAssetsResponse extends PaginatedResponse {

    private final Page<AssetSummary> page;

    public GetAllAssetsResponse(Page<AssetSummary> page) {
        this.page = page;
    }

    @JsonProperty
    public Page<AssetSummary> getPage() {
        return page;
    }
}
