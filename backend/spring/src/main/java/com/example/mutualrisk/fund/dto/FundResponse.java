package com.example.mutualrisk.fund.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.example.mutualrisk.fund.entity.Fund;
import com.example.mutualrisk.fund.entity.FundAsset;
import com.example.mutualrisk.sector.entity.Sector;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

public record FundResponse() {

	@Builder
	@Schema(name = "펀드 조회 데이터",description = "펀드 조회 전체 결과")
	public record FundResultDto(
		FundInfo fund,
		List<SectorInfo> sectors
	){


	}
	@Builder
	@Schema(name = "펀드 데이터",description = ""
		+ "개별 펀드 정보")
	public record FundInfo(
		Integer assetNum,
		String type,
		String ceo,
		String company,
		LocalDateTime submissionDate,
		Double QoQChangeOfValue,
		Double QoQTurnOver,
		List<FundAssetInfo> asset,
		long valueOfHoldings
	) {

		public static FundInfo of(Fund fund,List<FundAssetInfo> asset){
			return FundInfo.builder()
				.assetNum(asset.size())
				.type(fund.getType())
				.company(fund.getCompany())
				.submissionDate(fund.getSubmissionDate())
				.QoQChangeOfValue(fund.getQoQChangeOfValue())
				.QoQTurnOver(fund.getQoQTurnOver())
				.asset(asset)
				.valueOfHoldings(fund.getValueOfHoldings())
				.build();
		}

	}
	@Builder
	@Schema(name = "펀드 요약조회 데이터",description = "펀드 요약조회 전체 결과, 펀드 페이지에 필요한 모든 데이터를"
		+ "담는다")
	public record FundSummaryResultDto(
		Integer fundNum,
		List<FundSummaryInfo> funds,
		Fund topHoldAndBuyAmount
	){


	}

	@Builder
	@Schema(name = "펀드 요약정보",description = "상위 투자운용사 목록 정보, 상단의 이미지에 부분에 사용")
	public record FundSummaryInfo(
		String id,
		String ceo,
		String company,
		String image,
		Long valueOfHoldings
	){
		public static FundSummaryInfo from(Fund fund){
			return FundSummaryInfo.builder()
				.id(fund.getId())
				.ceo(fund.getCeo())
				.image(fund.getImage())
				.company(fund.getCompany())
				.valueOfHoldings(fund.getValueOfHoldings())
				.build();
		}
	}

	@Builder
	@Schema(name = "펀드 자산 상세 데이터",description = "펀드에 속하는 자산의 데이터"
		+ "code가 -1이면 기타자산에 속함")
	public record FundAssetInfo(
		Integer assetId,
		String code,
		String name,
		String region,
		Double dailyChangeRate,
		Integer rank,
		Boolean interest,
		Long valueOfHolding,
		Double currentValue
	){
		public static FundAssetInfo of(FundAsset item,Double dailyChangeRate,Double currentValue,Integer rank,Boolean interest){
			return FundAssetInfo.builder()
				.assetId(item.getAssetId())
				.code(item.getCode())
				.name(item.getName())
				.region(item.getRegion())
				.dailyChangeRate(dailyChangeRate)
				.rank(rank)
				.interest(interest)
				.currentValue(currentValue)
				.valueOfHolding(item.getValueOfHolding())
				.build();
		}

	}

	@Builder
	@Schema(name = "섹터편중 데이터",description = "현재 포트폴리오의 각 섹터에 대한 비중을 가지는 데이터")
	public record SectorInfo(
		Integer sectorId,
		String name,
		Double weight
	){
		public static SectorInfo of(Sector sector,Double ratio){
			return SectorInfo.builder()
				.sectorId(sector.getId())
				.name(sector.getName())
				.weight(ratio)
				.build();
		}
	}

	@Builder
	@Schema(name = "펀드 평가액 기록 데이터",description = "포트폴리오의 기간 별 평가액 데이터")
	public record FundPortfolioRecord(
		SubmissionDate submissionDate,
		Double fundValueOfHolding,
		Double sp500ValueOfHolding
	){

		public static FundPortfolioRecord of(SubmissionDate submissionDate,Double fundValueOfHolding,Double sp500ValueOfHolding){
			return FundPortfolioRecord.builder()
				.submissionDate(submissionDate)
				.fundValueOfHolding(fundValueOfHolding)
				.sp500ValueOfHolding(sp500ValueOfHolding)
				.build();
		}
	}

	@Builder
	@Schema(name = "제출일 데이터", description = "제출일(연도,분기)를 표현하는 데이터")
	public record SubmissionDate(
		String year,
		String quarter
	){

		public static SubmissionDate of(LocalDateTime submissionDate){

			return SubmissionDate.builder()
				.year(String.valueOf(submissionDate.getYear()))
				.quarter(parseQuarter(submissionDate))
				.build();
		}

		private static String parseQuarter(LocalDateTime submissionDate){

			// 분기 계산
			String quarter = "";

			int month = submissionDate.getMonthValue();
			if(month >= 1 && month <= 3){
				quarter = "1Q";
			}
			else if(month >=4 && month <= 6){
				quarter = "2Q";
			}
			else if(month >=7 && month <=9){
				quarter = "3Q";
			}
			else{
				quarter = "4Q";
			}

			return quarter;
		}


	}

}
