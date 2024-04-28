package com.example.AssetTracker_V2.core;

import com.example.AssetTracker_V2.data.*;
import com.example.AssetTracker_V2.domain.Asset;
import com.example.AssetTracker_V2.persistance.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Service
public class AssetService {

    @Autowired
    AssetRepository assetRepository;

    /**
     * Get all the assets being stored in the repository
     *
     * @param request to get all the assets containing the page number of the asset list
     *
     * @return response page containing the list of assets
     */
    public GetAllAssetsResponse getAllAssets(GetAllAssetsRequest request){

        int pageSize = Math.max(request.getPageSize(), 100);

        Pageable pageable = PageRequest.of(request.getPageNumber(), pageSize, Sort.by("purchaseDate").ascending() );

        List<AssetSummary> assetSummaries = new ArrayList<>();

        for(Asset asset : assetRepository.findAll(pageable)) {
            assetSummaries.add(new AssetSummary(    asset.getCost(),
                                                    asset.getCurrentValue(),
                                                    asset.getDepreciationRate(),
                                                    asset.getPurchaseDate(),
                                                    asset.getTitle()    ));
        }

        long totalCount = assetRepository.count();
        Page<AssetSummary> page = new PageImpl<>(assetSummaries, pageable, totalCount);

        return new GetAllAssetsResponse(page);
    }

    /**
     * Get the response containing the total count, cost and current value of all the assets
     *
     * @param request .
     *
     * @return object containing the total count, cost and current value of the assets
     */
    public GetAllAssetsSummaryResponse getAssetsSummary(GetAllAssetsSummaryRequest request){
        return  new GetAllAssetsSummaryResponse(assetRepository.count(),
                                                assetRepository.costOfAllAssets(),
                                                assetRepository.valueOfAllAssets() );
    }

    /**
     * Saves the asset sent to the function, into the asset repository
     *
     * @param request containing all the details like cost, depreciation rate, purchase date, and title of the asset
     *
     * @return the errors if any or the message stating that the asset was saved
     */
    public SaveAssetResponse saveAsset(SaveAssetRequest request){

        BigDecimal cost=request.getCost();
        InputCurrency currency= InputCurrency.valueOf(request.getCurrency());
        cost=cost.divide(BigDecimal.valueOf(currency.getConversionToUSD()),2, RoundingMode.HALF_UP);

        assetRepository.save( new Asset(request.getTitle(),cost,request.getDepreciationRate(),request.getPurchaseDate()));

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
