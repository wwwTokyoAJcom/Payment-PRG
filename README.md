
# 💳 Spring Boot 결제 예제 (PRG 패턴 적용)

결제 완료 후 새로고침 시 중복 결제를 방지하기 위한 PRG(Post → Redirect → Get) 패턴 예제입니다.

## ✅ 실행 방법

```bash
./gradlew bootRun
```

브라우저에서 http://localhost:8080 에 접속

## ✅ 주요 기능

- 주문번호 및 금액 입력 → 결제 처리
- 중복 결제 방지를 위한 PRG 패턴 적용
- 결제 성공/실패 메시지 전달 (FlashAttribute 사용)
