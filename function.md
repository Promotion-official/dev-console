# 기능 명세서

## Account Controller

- ### login (<id | email>, pw)

  request parameter 를 토대로 로그인 작업 실행

- ### sign-up (id, pw, among_token)

  request parameter 를 토대로 회원가입 작업 실행

## API Statistic Controller

- ### num-of-developers

  Dev console 에 가입된 개발자 수를 정수형으로 반환

- ### num-of-requests-per-api

  api 별 총 요청 횟수를 정수형으로 반환

- ### api-requests-by-date

  특정 api 에 대한 일자별 요청 횟수를 정수형으로 반환

- ### total-api-usage-by-developers

  특정 개발자의 총 API 사용량을 정수형으로 반환

- ### statistical-information-update-time

  통계수치가 최종 갱신된 날짜를 yyyy.MM.dd hh:mm 형식의 문자열로 반환한다.

## Metadata Controller

- ### api-description(api)

  특정 api 에 대한 설명을 HTML 문서로 반환

## AuthorizeKey Controller

- ### auth-key-owned-by-developer(developer)

  특정 개발자가 소유하고 있는 인증키에 대한 정보를 다음과 같은 json 형식으로 반환

  authorize_key...

      "total_request_count" : \ int,
      
      "permission" : \ string,
      
      "key" : \ string,
      
      "api" : \ string

## Pending Controller

- ### pending-product (service-name, url, description)

  request parameter 를 토대로 product 권한의 인증키 발급을 위한 제품 신청 작업 실행