package com.example.AssetTracker_V2.core;

import com.example.AssetTracker_V2.data.*;
import com.example.AssetTracker_V2.domain.Asset;
import com.example.AssetTracker_V2.persistance.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AssetService {

    @Autowired
    AssetRepository assetRepository;

    public GetAllAssetsResponse getAllAssets(GetAllAssetsRequest request){

        Pageable pageable= PageRequest.of(request.getPageNumber(), request.getPageSize());
        final var assets=assetRepository.findAll(pageable);

        return new GetAllAssetsResponse();
    }

    public GetAllAssetsSummaryResponse getAssetsSummary(GetAllAssetsSummaryRequest request){

        return  new GetAllAssetsSummaryResponse(assetRepository.count(),
                assetRepository.costOfAllAssets(),
                assetRepository.valueOfAllAssets());
    }

    public SaveAssetResponse saveAsset(SaveAssetRequest request){

        assetRepository.save( new Asset(request.getTitle(),request.getCost(),request.getDepreciationRate(),request.getPurchaseDate()));

        return new SaveAssetResponse();
    }
}
