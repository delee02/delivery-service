# 배달 프로젝트

## 프로젝트 정보

##### -api(사용자) ,db, store-admin(가맹점) 세 개의 모듈
##### -개발기간: 3개월

##### -개발 인원: 1인

##### -개발 이유: 인터넷 강의를 바탕으로 프로젝트를 개발하였으며, 기본적인 Spring Boot 기능 구현부터 SSE(Server-Sent Events)를 활용한 실시간 알림 기능까지 심화된 기능을 적용하여 실무에서도 활용할 수 있는 기술을 익히고자 프로젝트를 진행하게 되었습니다. 개발은 약 3개월 정도의 시간이 소요되었으며, 본격적인 개발에 앞서 기본적인 환경 설정과 프로젝트 구조 설계를 미리 진행해 두었습니다.


## 사용한 기능
##### spring security를 통한 가맹점 서버 개발, filter exception 설정, interceptor을 통한 인증기반 적용, JWT토큰, sse를 사용한 알람 개발중

## 개발언어

##### Java 17

## 개발환경

##### IntelliJ
##### Docker 4.31.1
##### jdk corretto-17.0.12

## 기술스택
##### spring boot 3.3.1
##### mysql 8.0
##### rabbitMQ
##### swagger-ui

## API 설명

### user
##### /open-api/user/register 회원가입

##### /open-api/user/login 로그인

##### /api/user/me 내정보

### store
##### /open-api/user/register 가게 등록

##### /open-api/store-menu/register 가게 메뉴 등록

##### /api/store/search 가게 리스트(카테고리별)

##### /api/store-menu/search 가게별 메뉴 리스트

### user order

##### /api/user-order 주문하기

##### /api/user-order/id/{order-id} 주문 한 건에 대한 내역

##### /api/user-order/history 과거 주문 내역

##### /api/user-order/current 현재 진행중인 주문건

### store user

##### /open-api/store-user 가맹점 관리자 등록

##### /api/store-user/me 가맹점 관리자 정보

##### /api/sse/push-event

##### /api/sse/connect

##  DB설계

##### user: 사용자 테이블

##### user_order: 사용자 주문 테이블

##### user_order_menu: 사용자가 주문한 메뉴 테이블

##### store: 가게(가맹점) 테이블

##### store_menu: 가게(가맹점) 메뉴 테이블

##### stoer_user: 가게(가맹점) 관리자 테이블

![Image](https://github.com/user-attachments/assets/4aa56e0f-cbd2-477a-ae40-dce76066c3f0)
