📑 Features
===
## 📌 Constant

### Menu
- name, index, price
>#### Appetizer: 0
>- 양송이수프(0, 6_000)
>- 타파스(0, 5_500)
>- 시저샐러드(0, 8_000)
>#### Main: 1
>- 티본스테이크(1, 55_000)
>- 바비큐립(1, 54_000)
>- 해산물파스타(1, 35_000)
>- 크리스마스파스타(1, 25_000)
>#### Dessert: 2
>- 초코케이크(2, 15_000)
>- 아이스크림(2, 5_000)
>#### Drink: 3
>- 제로콜라(3, 3_000)
>- 레드와인(3, 60_000)
>- 샴페인(3, 25_000)

---
## 📌 Controller

### EventPlanner
- 고객의 입력을 받는다.
- 주문 메뉴를 저장한다.
- 이벤트 혜택을 출력한다.

---
## 📌 Model

### Validate
- 방문 날짜 입력값 검사
  - 🚫 숫자가 아닌 경우
  - 🚫 1 이상 31 이하의 수가 아닌 경우
- 주문 메뉴, 개수 검사
  - 🚫 올바르지 않은 형식으로 입력한 경우 (띄어쓰기, 문자열 끝 콤마 허용)
  - 🚫 메뉴판에 없는 메뉴를 입력한 경우
  - 🚫 메뉴의 개수가 숫자가 아닌 경우
  - 🚫 메뉴의 개수가 1 이상의 수가 아닌 경우
  - 🚫 중복 메뉴를 입력한 경우

### Order
- 이벤트 적용 여부 확인 (총주문 금액 10,000원 이상부터 적용)
- 주문 가능 여부 확인
  - 🚫 음료만 주문한 경우
  - 🚫 메뉴의 개수가 20개를 초과한 경우

### OrderCheck
- 총주문 금액 확인 (10,000원 이상부터 이벤트 적용)
- 🚫 음료만 주문한 경우
- 🚫 메뉴의 개수가 20개를 초과한 경우

### Event
- 크리스마스 디데이 할인
- 평일 할인(일요일~목요일)
- 주말 할인(금요일, 토요일)
- 특별 할인
- 증정 이벤트
- 총 혜택 금액 계산
- 이벤트 배지

---
## 📌 View

### InputView
- 12월 중 예상 방문 날짜를 입력받는다.
- 주문할 메뉴와 개수를 입력받는다.
  - 🚫 숫자가 아닌 경우
  - 🚫 1 이상 31 이하의 수가 아닌 경우
- 주문할 메뉴와 개수를 입력받는다.
  - 🚫 올바르지 않은 형식으로 입력한 경우 (띄어쓰기, 문자열 끝 콤마 허용)
  - 🚫 메뉴판에 없는 메뉴를 입력한 경우
  - 🚫 메뉴의 개수가 숫자가 아닌 경우
  - 🚫 메뉴의 개수가 1 이상의 수가 아닌 경우
  - 🚫 중복 메뉴를 입력한 경우

### OutputView
- 주문 메뉴를 출력한다.
- 할인 전 총주문 금액을 출력한다.
- 증정 메뉴를 출력한다.
- 혜택 내역을 출력한다.
- 총혜택 금액을 출력한다.
- 할인 후 예상 결제 금액을 출력한다.
- 이벤트 배지 내역을 출력한다.