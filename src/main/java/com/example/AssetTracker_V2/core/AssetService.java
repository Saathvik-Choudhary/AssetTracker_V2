package com.example.AssetTracker_V2.core;

import com.example.AssetTracker_V2.data.*;
import com.example.AssetTracker_V2.domain.Asset;
import com.example.AssetTracker_V2.persistance.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

@Service
public class AssetService {

    @Autowired
    AssetRepository assetRepository;

    public GetAllAssetsResponse getAllAssets(GetAllAssetsRequest request){

        // Validate page size
        int pageSize = Math.max(request.getPageSize(), 100);

        Sort sort=Sort.by("purchaseDate").ascending();

        Pageable pageable = PageRequest.of(request.getPageNumber(), pageSize,sort);
        final Page<Asset> assets = assetRepository.findAll(pageable);

        List<AssetSummary> assetSummaries = new ArrayList<>();

        for(Asset asset : assets.getContent()) {
            assetSummaries.add(new AssetSummary(
                    asset.getCost(),
                    asset.getCurrentValue(),
                    asset.getDepreciationRate(),
                    asset.getPurchaseDate(),
                    asset.getTitle()
            ));
        }

        // Get the total count of assets
        long totalCount = assetRepository.count();

        // Create the Page object
        Page<AssetSummary> page = new PageImpl<>(assetSummaries, pageable, totalCount);

        return new GetAllAssetsResponse(page);
    }


    /*
    public GetAllAssetsResponse getAllAssets(GetAllAssetsRequest request){

        Pageable pageable = PageRequest.of(request.getPageNumber(), request.getPageSize());
        final Page<Asset> assets = assetRepository.findAll(pageable);

        List<AssetSummary> assetSummaries = new ArrayList<>();

        for(Asset asset : assets.getContent()) {
            assetSummaries.add(new AssetSummary(
                    asset.getCost(),
                    asset.getCurrentValue(),
                    asset.getDepreciationRate(),
                    asset.getPurchaseDate(),
                    asset.getTitle()
            ));
        }

        // Get the total count of assets
        long totalCount = assetRepository.count();

        // Create the Page object
        Page<AssetSummary> page = new PageImpl<>(assetSummaries, pageable, totalCount);

        return new GetAllAssetsResponse(page);
    }

     */

    public GetAllAssetsSummaryResponse getAssetsSummary(GetAllAssetsSummaryRequest request){

        return  new GetAllAssetsSummaryResponse(assetRepository.count(),
                assetRepository.costOfAllAssets(),
                assetRepository.valueOfAllAssets());
    }

    public SaveAssetResponse saveAsset(SaveAssetRequest request){

        assetRepository.save( new Asset(request.getTitle(),request.getCost(),request.getDepreciationRate(),request.getPurchaseDate()));

        return new SaveAssetResponse();
    }

    @Scheduled(cron = "0 0 0 * * *")
    public void updateColumn() {
        final var assets= assetRepository.findAll();

        for(var asset:assets){
            asset.setCurrentValue();
        }
    }
}
