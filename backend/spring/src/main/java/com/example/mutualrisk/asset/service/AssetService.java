package com.example.mutualrisk.asset.service;

import static com.example.mutualrisk.asset.dto.AssetRequest.*;
import static com.example.mutualrisk.asset.dto.AssetResponse.*;

import com.example.mutualrisk.asset.dto.AssetResponse.AssetResultDto;
import com.example.mutualrisk.common.dto.CommonResponse.ResponseWithData;
import com.example.mutualrisk.common.dto.CommonResponse.ResponseWithMessage;
import com.example.mutualrisk.common.enums.Order;
import com.example.mutualrisk.common.enums.OrderCondition;

public interface AssetService {
    ResponseWithData<AssetResultDto> searchByKeyword(String keyword);

    ResponseWithData<AssetResultDto> getUserInterestAssets(Integer userId, OrderCondition orderCondition, Order order);

    ResponseWithMessage addInterestAsset(Integer userId,InterestAssetInfo asset);

	ResponseWithMessage deleteInterestAsset(Integer userId, Integer assetId);

	ResponseWithData<AssetResultDto> getAssetByAssetId(Integer assetId);

	ResponseWithData<StockTrendWithDetail> getStockTrendWithDetail(Integer assetId);

	ResponseWithData<ETFInfo> getETFDetail(Integer assetId);
}
