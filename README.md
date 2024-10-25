# 교회 웹페이지 제작

현재 배포 링크: [교회 웹페이지](https://port-0-lordandchrist-m2hbtbap6d491510.sel4.cloudtype.app/)

## 프로젝트 개요

이 프로젝트는 Spring Framework와 MySQL을 사용하여 교회 웹페이지를 구현한 것입니다. CloudType을 사용해 배포했으며, 교회의 여러 섹션을 소개하고, 새가족 등록, 예배 영상, 양육 신청 등의 기능을 제공합니다.

## 기능

### 1. 홈 (Home)
홈 화면은 교회의 첫 인상을 담고 있으며, 환영 메시지와 교회 관련 사진이 표시됩니다.
![image](https://github.com/user-attachments/assets/5066602d-10e4-4d6d-816f-d24e57728206)


---

### 2. 환영합니다
- **교회 소개**: 
  - 교회에 대한 소개 내용을 담은 페이지입니다. 교회 사진과 소개글을 볼 수 있습니다.
![image](https://github.com/user-attachments/assets/71e408ae-7e44-499f-abb4-aa695804e151)

  
- **새가족 등록하기**: 
  - 새가족 등록 페이지입니다. 개인 정보 동의 절차를 거친 후 등록된 정보는 MySQL 데이터베이스에 저장됩니다.
![image](https://github.com/user-attachments/assets/7488a882-e299-4168-ba9c-413f3c964134)


---

### 3. 소개합니다
- **담임 목사님 소개**: 
  - 담임 목사님의 소개를 담은 페이지로, 목사님의 메시지와 사진이 포함되어 있습니다.
![image](https://github.com/user-attachments/assets/612c56e8-d985-4d0d-9b1e-f22880d33282)

  
- **교회 오시는 길**: 
  - 교회 주소와 함께 구글 맵을 사용하여 교회의 위치를 보여줍니다.
![image](https://github.com/user-attachments/assets/860504bf-e6b1-4d66-ad7d-ac43c1397aeb)


---

### 4. 예배합니다
- **예배 영상**: 
  - 예배 영상을 유튜브 URL로 삽입하여 iframe을 통해 제공하고 있습니다. 해당 URL은 프론트엔드에서 입력되어 DTO를 통해 Controller, Service, JPA Repository와 연결된 MySQL DB로 저장됩니다. 사용자는 예배 영상을 쉽게 볼 수 있습니다.
![image](https://github.com/user-attachments/assets/2af39bf9-3b58-4e54-8364-d1545b7cc6c1)

  - 예배 영상 클릭 시 
<img width="1440" alt="image" src="https://github.com/user-attachments/assets/db420f5b-721d-4426-8d23-a539f9bd8297">



---

### 5. 양육합니다
- **양육 신청**: 
  - 교회의 양육 신청 페이지로, 사용자가 양육 프로그램을 신청할 수 있습니다. 신청 정보는 MySQL 데이터베이스에 저장됩니다.
![image](https://github.com/user-attachments/assets/4808e816-80a5-4478-b2f1-27c2eb2e8f73)


---

### 6. 선교합니다
- **선교 현황**: 
  - 선교지와 선교사님의 정보를 담은 페이지입니다. 선교지 정보와 함께 오른쪽에는 관련 이미지를 표시하여 선교 현황을 한눈에 볼 수 있도록 구성했습니다.
![image](https://github.com/user-attachments/assets/15f6f33c-e64d-4603-9bd5-9be7008742c1)


---

## 기술 스택

- **Back-end**: Spring Framework, JPA, MySQL
- **Front-end**: HTML, CSS, JavaScript, Thymeleaf
- **Database**: MySQL
- **배포**: CloudType


## 설치 및 실행 방법

1. 이 레포지토리를 클론합니다.
    ```bash
    git clone https://github.com/ksh01p/church-webpage.git
    ```

2. 프로젝트 폴더로 이동합니다.
    ```bash
    cd church-webpage
    ```

3. 필요한 의존성을 설치합니다.
    ```bash
    ./mvnw install
    ```

4. MySQL 데이터베이스 설정을 완료하고, `application.properties` 파일에서 DB 설정을 업데이트합니다.

5. 서버를 실행합니다.
    ```bash
    ./mvnw spring-boot:run
    ```

6. 웹 브라우저에서 [http://localhost:8080](http://localhost:8080)로 접속하여 웹페이지를 확인합니다.

## 기여

기여를 원하시면 issue를 등록하거나 pull request를 보내주세요. 감사합니다!

## 라이선스

MIT License를 따릅니다.
