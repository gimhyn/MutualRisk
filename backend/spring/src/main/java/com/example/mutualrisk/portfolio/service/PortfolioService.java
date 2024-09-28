package com.example.mutualrisk.portfolio.service;

import java.util.List;

import com.example.mutualrisk.common.dto.CommonResponse.*;
import com.example.mutualrisk.common.enums.PerformanceMeasure;
import com.example.mutualrisk.common.enums.TimeInterval;
import com.example.mutualrisk.fund.dto.FundResponse;
import com.example.mutualrisk.fund.dto.FundResponse.SectorInfo;
import com.example.mutualrisk.portfolio.dto.PortfolioResponse.*;


public interface PortfolioService {
    ResponseWithData<PortfolioResultDto> getPortfolioInfo(Integer userId);
    ResponseWithMessage sendRefreshMail();

    ResponseWithData<PortfolioBacktestingResultDto> getUserPortfolioPerformance(TimeInterval timeInterval, PerformanceMeasure measure, Integer userId);

    ResponseWithData<List<SectorInfo>> getUserPortfolioSector(Integer userId);
}
