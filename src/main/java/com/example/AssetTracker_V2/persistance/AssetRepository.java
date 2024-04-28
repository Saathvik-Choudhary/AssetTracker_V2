package com.example.AssetTracker_V2.persistance;

import com.example.AssetTracker_V2.data.GetAllAssetsResponse;
import com.example.AssetTracker_V2.domain.Asset;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;

@Repository
public interface AssetRepository extends JpaRepository<Asset,Long> , JpaSpecificationExecutor<Asset> {

    @Query("SELECT SUM"
            + "(cost) "
            + "FROM Asset")
    BigDecimal costOfAllAssets();

    @Query("SELECT SUM"
            + "(currentValue)"
            + " FROM Asset")
    BigDecimal valueOfAllAssets();


}
