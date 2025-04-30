package com.couponmoa.backend.couponmoaai.domain.coupon.recommend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class RecommendRequest {
    private List<String> keywords;
    private List<CouponDto> coupons;
}
