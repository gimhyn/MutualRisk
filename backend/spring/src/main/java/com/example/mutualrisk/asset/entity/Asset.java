package com.example.mutualrisk.asset.entity;

import com.example.mutualrisk.common.entity.BaseEntity;
import com.example.mutualrisk.common.enums.Market;
import com.example.mutualrisk.industry.entity.Industry;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class Asset extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name" ,nullable = false)
	private String name;

	@Column(name = "code" ,nullable = false)
	private String code;

	@Enumerated(EnumType.STRING)
	@Column(name = "market")
	private Market market;

	@Enumerated(EnumType.STRING)
	@Column(name = "region")
	private Region region;

	@Column(name = "expected_return" ,nullable = false)
	private Double expectedReturn;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "industry_id")
	private Industry industry;

	@Column(name = "image_path")
	private String imagePath;

	@Column(name = "image_name")
	private String imageName;

	@Override
	public String toString() {
		return "Asset{" +
			"id=" + id +
			", name='" + name + '\'' +
			", code='" + code + '\'' +
			", region=" + region +
			", expectedReturn=" + expectedReturn;
	}
}