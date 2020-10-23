# cafe-pos

- 비트캠프 2차 해커톤.
- pos 시스템 구현 프로젝트.

## 구현하고자 한것들

- 관리자 회원가입 / 로그인
- 메뉴추가, 조회, 삭제, 수정 command
- 고객 입장 메뉴 주문 - 메뉴 -> 가격 -> 수량 선택 -> 합산 -> 결제

### 개발 일지

- pos-client, pos-server로 폴더 나눔.
- 메뉴는 핫커피, 콜드커피, 베이커리, 아이스크림으로 결정.
- HotCoffee, ColdCoffeem Bakery, Icecream 각각 도메인 생성. (com.pos.pms.domain)
- Add / List / Delete / Update Command 생성. (com.pos.pms.handler)
- AppInitListener, DataHandlerListener, ReQuestMappingListener 생성. (com.pos.pms.litener)
- com.pos.util - prompt 생성
- com.pos.context - ApplicationContextListener 생성

## 실행결과

- Command 들은 잘 실행되었으나 관리자가입 / 로그인 구현 실패.
- 추가 시킨 메뉴들의 이름만 빼내어 고객께 출력하려했으나 실행 실패.

### 느낀점

- 아직 server / client 에 익숙치 않은 것 같고, 코드가 한 눈에 들어오지 않음.
- 각각의 코드들이 어떤 방식으로 상호작용하는 것인지 완벽히 이해하고 있지 못함.
- HotCoffeeAddCommand - /hotCoffee/add 명령어로 메뉴를 추가한 뒤 getName으로 이름들만 가져오고 싶었으나, 실력이 부족하였음.
- 공부가 많이 부족함.
