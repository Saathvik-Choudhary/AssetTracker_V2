package com.example.AssetTracker_V2.core;
import com.example.AssetTracker_V2.data.*;
import com.example.AssetTracker_V2.domain.Asset;
import com.example.AssetTracker_V2.persistance.AssetRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class AssetServiceTest {

    @Mock
    private AssetRepository assetRepository;

    @InjectMocks
    private AssetService assetService;

    @Test
    void getAllAssets_Success() {
        // Mock data
        List <Asset> assets = new ArrayList<>();
        assets.add(new Asset("Laptop", BigDecimal.valueOf(1000), BigDecimal.valueOf(0.01), null));
        assets.add(new Asset("Phone", BigDecimal.valueOf(800), BigDecimal.valueOf(0.5), null));
        assets.add(new Asset("Tablet", BigDecimal.valueOf(500), BigDecimal.valueOf(0.02), null));

        // Mock repository behavior
        when(assetRepository.findAll(any(Pageable.class))).thenReturn(new PageImpl<>(assets));

        // Test service method
        GetAllAssetsRequest request = new GetAllAssetsRequest();
        GetAllAssetsResponse response = assetService.getAllAssets(request);

        // Verify
        assertNotNull(response);
        assertEquals(3, response.getPage().getSize());
    }

    @Test
    void getAllAssets_EmptyRepository() {
        // Mock repository behavior
        when(assetRepository.findAll(any(Pageable.class))).thenReturn(new PageImpl<>(new ArrayList <>()));

        // Test service method
        GetAllAssetsRequest request = new GetAllAssetsRequest();
        GetAllAssetsResponse response = assetService.getAllAssets(request);

        // Verify
        assertNotNull(response);
        assertEquals(0, response.getPage().getSize());
    }

    @Test
    void getAssetsSummary_Success() {
        // Mock repository behavior
        when(assetRepository.count()).thenReturn(5L);
        when(assetRepository.costOfAllAssets()).thenReturn(BigDecimal.valueOf(3000));
        when(assetRepository.valueOfAllAssets()).thenReturn(BigDecimal.valueOf(2500));

        // Test service method
        GetAllAssetsSummaryRequest request = new GetAllAssetsSummaryRequest();
        GetAllAssetsSummaryResponse response = assetService.getAssetsSummary(request);

        // Verify
        assertNotNull(response);
        assertEquals(5L, response.getCount());
        assertEquals(BigDecimal.valueOf(3000), response.getCost());
        assertEquals(BigDecimal.valueOf(2500), response.getValue());
    }

    @Test
    void saveAsset_Success() {
        // Mock request
        SaveAssetRequest request = new SaveAssetRequest("Laptop", BigDecimal.valueOf(1000), "USD", BigDecimal.valueOf(0.1), null);

        // Test service method
        SaveAssetResponse response = assetService.saveAsset(request);
        assertNotNull(response);

    }

    @Test
    void saveAsset_CurrencyConversion() {
        // Mock request
        SaveAssetRequest request = new SaveAssetRequest("Laptop", BigDecimal.valueOf(1000), "EUR", BigDecimal.valueOf(0.1), null);

        // Mock repository behavior
        when(assetRepository.save(any(Asset.class))).thenReturn(new Asset());

        // Test service method
        assetService.saveAsset(request);
        verify(assetRepository, times(1)).save(argThat(asset -> {
            // Check if cost is converted to USD
            return asset.getCost().equals(BigDecimal.valueOf(1000).divide(BigDecimal.valueOf(1.22), 2, RoundingMode.HALF_UP));
        }));
    }

    @Test
    void saveAsset_InvalidCurrency() {
        // Mock request
        SaveAssetRequest request = new SaveAssetRequest("Laptop"
                , BigDecimal.valueOf(1000)
                , "INVALID"
                , BigDecimal.valueOf(0.01)
                , null);

        // Test service method
        SaveAssetResponse response = assetService.saveAsset(request);
        assertNotNull(response);
    }


}


