package com.example.AssetTracker_V2.api;

import com.example.AssetTracker_V2.AssetTrackerV2Application;
import com.example.AssetTracker_V2.core.AssetService;
import com.example.AssetTracker_V2.data.*;
import com.example.AssetTracker_V2.domain.Asset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/asset")
public class AssetController {

    @Autowired
    AssetService assetService;

    @CrossOrigin
    @GetMapping("/summary")
    public ResponseEntity<GetAllAssetsSummaryResponse> getAssetSummary(GetAllAssetsSummaryRequest request){

        return ResponseEntity.ok(assetService.getAssetsSummary(request));
    }

    @CrossOrigin
    @GetMapping("/all")
    public Page<AssetSummary> getAllAssets(GetAllAssetsRequest request){
        return assetService.getAllAssets(request).getPage();
    }

    @CrossOrigin
    @PostMapping("/save")
    public ResponseEntity<SaveAssetResponse> saveAsset(@RequestBody SaveAssetRequest request){

        return ResponseEntity.ok(assetService.saveAsset(request));
    }
}
