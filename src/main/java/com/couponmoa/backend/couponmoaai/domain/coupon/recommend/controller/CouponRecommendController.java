package com.couponmoa.backend.couponmoaai.domain.coupon.recommend.controller;

import com.couponmoa.backend.couponmoaai.domain.coupon.recommend.dto.RecommendRequest;
import com.couponmoa.backend.couponmoaai.domain.coupon.recommend.service.AiRecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/coupon/recommend-ai")
@RequiredArgsConstructor
public class CouponRecommendController {

    private final AiRecommendationService aiRecommendationService;

    @PostMapping
    public Map<String, List<Long>> recommend(@RequestBody RecommendRequest request) {
        return Map.of("recommended_coupon_ids", aiRecommendationService.recommendCouponIds(request));
    }
}