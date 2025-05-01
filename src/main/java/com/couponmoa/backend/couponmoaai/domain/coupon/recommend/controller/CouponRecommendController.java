package com.couponmoa.backend.couponmoaai.domain.coupon.recommend.controller;

import com.couponmoa.backend.couponmoaai.domain.coupon.recommend.dto.RecommendRequest;
import com.couponmoa.backend.couponmoaai.domain.coupon.recommend.service.AiRecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/api/v1/coupon/recommend-ai")
@RequiredArgsConstructor
public class CouponRecommendController {

    private final AiRecommendationService aiRecommendationService;

    // coupon 서버에서 실행하는 코드
    @PostMapping
    public List<Long> recommend(@RequestBody RecommendRequest request) {
        return aiRecommendationService.recommendCouponIds(request);
    }
}
