package com.couponmoa.backend.couponmoaai.domain.coupon.recommend.service;

import com.couponmoa.backend.couponmoaai.domain.coupon.recommend.dto.RecommendRequest;
import com.couponmoa.backend.couponmoaai.domain.coupon.recommend.dto.CouponDto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class AiRecommendationService {

    private final ChatClient chatClient;
    private final ObjectMapper objectMapper;

    public List<Long> recommendCouponIds(RecommendRequest recommendRequest) {
        String couponList = recommendRequest.getCoupons().stream()
                .map(c -> String.format("ID: %d, Name: %s, Description: %s, Store: %s",
                        c.getCouponId(), c.getName(), c.getDescription(), c.getStoreName()))
                .collect(Collectors.joining("\n"));

        String prompt = """
            Based on the keywords %s, recommend up to 5 coupon IDs from the following list:
            %s
            Return a JSON object with a key 'recommended_coupon_ids' containing a list of up to 5 coupon IDs.
            """.formatted(recommendRequest.getKeywords(), couponList);

        try {
            String response = chatClient.prompt()
                    .user(prompt)
                    .call()
                    .content();
            Map<String, List<Long>> parsed = objectMapper.readValue(response, new TypeReference<Map<String, List<Long>>>() {});
            List<Long> recommendedIds = parsed.getOrDefault("recommended_coupon_ids", Collections.emptyList());
            return recommendedIds;
        } catch (Exception e) {
            log.error("Failed to process Vertex AI response", e);
            return Collections.emptyList();
        }
    }
}