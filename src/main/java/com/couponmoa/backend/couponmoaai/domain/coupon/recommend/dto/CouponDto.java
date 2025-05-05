package com.couponmoa.backend.couponmoaai.domain.coupon.recommend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CouponDto {
    private Long couponId;
    private String name;
    private String description;
    private String storeName;
}
