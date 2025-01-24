# 배달 프로젝트

## 프로젝트 정보

##### -api(사용자) ,db, store-admin(가맹점) 세 개의 모듈
##### -개발기간: 3개월

##### -개발 인원: 1인

##### -개발 이유: 인터넷 강의를 바탕으로 프로젝트를 만들었으며, 기본적인 기능 구현부터 sse를 사용한 알림 기능까지 심화된 기능 만들 수 있어서 개발하게 되었습니다.  

## 주요기능 
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

##### /open-api/store-menu/register 가게 메뉴 등록?

##### /api/store/search 가게 찾기

##### /api/store-menu/search 가게 메뉴 찾기?

### user order

##### /api/user-order ?

##### /api/user-order/id/{order-id} 나의 특정 주문 보기

##### /api/user-order/history 주문 내역

##### /api/user-order/current 최근 주문?

### store user

##### /open-api/store-user 가맹점 관리자 등록

##### /api/store-user/me 가맹점 관리자 정보

##### /api/sse/push-event

##### /api/sse/connect

##  DB설계
![Image](https://github.com/user-attachments/assets/4aa56e0f-cbd2-477a-ae40-dce76066c3f0)
