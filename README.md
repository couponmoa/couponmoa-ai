🏪 couponmoa-ai

📌 개요

Couponmoa AI 서버는 Couponmoa 프로젝트의 핵심 컴포넌트로, AI 기반 쿠폰 추천 기능을 제공합니다. Google Cloud의 Vertex AI Gemini 모델을 활용하여 사용자 키워드와 쿠폰 데이터를 분석, 최적의 쿠폰을 실시간으로 추천합니다. 이 서버는 쿠폰 서버와 긴밀히 연계되어 사용자 경험을 향상시키며, 효율적인 API 설계로 빠르고 안정적인 서비스를 보장합니다.

🧩 주요 기능

키워드 기반 쿠폰 추천: 사용자 입력 키워드를 바탕으로 최대 5개의 쿠폰 ID를 추천, JSON 형식 응답 제공.
Vertex AI Gemini 통합: Google Cloud의 Vertex AI Gemini 모델을 사용해 고성능 AI 프롬프트 처리.
효율적인 API 엔드포인트: /api/v1/coupon/recommend-ai를 통해 쿠폰 서버와 연계, 간결한 요청/응답 구조.
JSON 데이터 처리: ObjectMapper를 활용한 안정적인 JSON 파싱으로 추천 결과 신뢰성 보장.
확장성 고려: Spring Boot 3.4.5와 Gradle 기반으로, 확장 및 유지보수 용이.
🛠 기술 스택

언어: Java 17
프레임워크: Spring Boot 3.4.5
AI 모델: Google Cloud Vertex AI Gemini (gemini-1.0-pro)
의존성 관리: Gradle, Spring AI BOM 1.0.0-SNAPSHOT
데이터 처리: Jackson (ObjectMapper)로 JSON 직렬화/역직렬화
배포: 로컬 및 클라우드 환경 지원 (port: 8086)
