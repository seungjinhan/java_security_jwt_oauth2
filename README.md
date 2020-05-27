# OAuth2 인증처리
## 개발환경
 1. spring boot
 2. spring security
 3. io.jsonwebtoken
 
## 프로젝트 프로세스
 1. id, password로 인증요청  -> 인증성공 -> access token, refresh token 발급
 2. api요청시 access token으로 요청
 3. refresh token으로 access token, refresh token 재발급

* token은 유효성검증(token string 정확성 and expire time)

## 설정
 1. application.properties에 만료시간 및 secure key 설정
 - jwt.access.token.secure.key=access_key_1234
 - jwt.refresh.token.secure.key=refresh_key_1234
 - jwt.access.token.expire.time=10
 - jwt.refresh.token.expire.time=100

 2. 토큰재발급 url 설정
 - jwt.get.access.token.url=/get_access_token

## 실행
 1. 인증
  - url: localhost:8080/authenticate
  - body: 
  ```
  {  
 	"username":"user",
	"password":"1234"
  }
  ```
  - response body:
  ```
   {
    "jwt": {
        "accessToken": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwiZXhwIjoxNTkwNTM3Njg5LCJpYXQiOjE1OTA1MzcwODl9.DjZeFK1eCok8Ix3YUFvU1D94y5TSGUvMvTWrDSDIGe0",
        "refreshToken": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwiZXhwIjoxNTkwNTQzMDkwLCJpYXQiOjE1OTA1MzcwOTB9.aad9zvED8vvHcUTuEZ8VSV1y6lhF3toylTUdWTEzk0U"
    }
   }    
   ```

 2. API 요청
  - URL: http://localhost:8080/hello
  - Header: ( access token 사용)
    - Authorization:Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwiZXhwIjoxNTkwNTM3Njg5LCJpYXQiOjE1OTA1MzcwODl9.DjZeFK1eCok8Ix3YUFvU1D94y5TSGUvMvTWrDSDIGe0
  - response body : "Hello World"  
 
 3. 재발행요청
  - URL: http://localhost:8080/get_access_token
  - Header: ( refresh Token 사용) 
   - Authorization:Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwiZXhwIjoxNTkwNTQzMDkwLCJpYXQiOjE1OTA1MzcwOTB9.aad9zvED8vvHcUTuEZ8VSV1y6lhF3toylTUdWTEzk0U
  - response body:
 ```
 {
    "jwt": {
        "accessToken": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwiZXhwIjoxNTkwNTQxOTgwLCJpYXQiOjE1OTA1NDEzODB9.fy4G0Hv6DA99QTQ9mOqexyqueWcrEIv6EC0zu9CQOvM",
        "refreshToken": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwiZXhwIjoxNTkwNTQ3MzgwLCJpYXQiOjE1OTA1NDEzODB9.diEpyIY3exEotFdXVLBT_ofkcrAhKmGUhH20BssZJ2s"
    }
}
```
