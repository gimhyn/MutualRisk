package com.example.mutualrisk.asset.repository;

import com.example.mutualrisk.asset.entity.Asset;
import com.example.mutualrisk.asset.entity.AssetHistory;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface AssetHistoryRepositoryCustom {
    List<AssetHistory> findRecentTwoAssetHistory(Asset asset);

    Optional<AssetHistory> findRecentHistoryOfAsset(Asset asset);
    List<AssetHistory> findRecentHistoryOfAssets(List<Asset> assets, LocalDateTime dateTime);

    Optional<AssetHistory> findRecentHistoryOfAssetByAssetId(Integer assetId);
    Optional<AssetHistory> findHistoryOfAssetByAssetId(Integer assetId, LocalDateTime dateTime);

}
