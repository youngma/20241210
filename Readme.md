# 프로젝트명

## 📋 목차
- [개요](#개요)
- [기술 스택](#기술-스택)
- [프로젝트 구조](#프로젝트-구조)
- [주요 기능](#주요-기능)
- [실행 방법](#실행-방법)
- [API 문서](#api-문서)
- [데이터베이스](#데이터베이스)


## 📝 개요
- 무신사 코딩 테스트
- 카테고리, 브랜드, 상품 관리
- 2024.12.03~
- 1인

## 🛠 기술 스택
### Backend
- Java 17
- Spring Boot 3.x
- Spring Data JPA
- QueryDSL
- H2 Database

### Build Tool
- Gradle

## 📂 프로젝트 구조
```
src
├── main
│   ├── java
│   │   └── musinsa.bob.main
│   │       ├── config
│   │       ├── controller
│   │       ├── service
│   │       ├── repository
│   │       ├── entity
│   │       ├── mapper
│   │       ├── vo
│   │       └── exception
│   │       └── enums
│   └── resources
│       ├── application.yml
│       └── static
└── test
    └── java
```

## 💡 주요 기능
### 1. 카테고리
- Enum 으로 구현

### 2. 브랜드 관리
- 브랜드 조회 ()
```
GET /brand/{code}
```
- 브랜드 등록
```
POST /brand

Request Body

{
  "code": "B",
  "name": "C-name"
 }
```
- 브랜드 수정
```
PUT /brand

Request Body

{
  "code": "B",
  "name": "C-name"
 }
```
- 브랜드 삭제 
```
DELETE /brand/{code}
```

### 2. 상품 관리
- 상품 등록
```
POST /item

Request Body

{
    "brand": "B",
    "category": "TOP",
    "price": 1000
}
```
- 상품 수정
```
PUT /item

Request Body

{
    "seq": 74,
    "brand": "B",
    "category": "TOP",
    "price": 1000
}
```
- 상품 삭제
```
DELETE /item/{seq}
```

### 3. 기타 구현 API
- 카테고리 별 최저가격 브랜드와 상품 가격, 총액을 조회하는 API
```
GET /item/group/category/price/min
```
- 단일 브랜드로 모든 카테고리 상품을 구매할 때 최저가격에 판매하는 브랜드와 카테고리의 상품가격, 총액을 조회하는 API
```
GET /item/group/brand/price/min
```
- 카테고리 이름으로 최저, 최고 가격 브랜드와 상품 가격을 조회하는 API
```
GET http://localhost:8082/item/brand/price/{category}
```

## 🚀 실행 방법
```bash
# 프로젝트 클론
git clone https://github.com/youngma/20241210.git

# 디렉토리 이동
cd project

# 빌드
./gradlew build

# 실행
java -jar build/libs/musinsa_ct-0.0.1-SNAPSHOT.jar
```



### 테이블 설명
- BRAND
```
CREATE TABLE brand
(
    code        VARCHAR(255) NOT NULL,
    inserted_at TIMESTAMP,
    inserted_id VARCHAR(255),
    updated_at  TIMESTAMP,
    updated_id  VARCHAR(255),
    brand_name  VARCHAR(255) NOT NULL,
    CONSTRAINT pk_brand PRIMARY KEY (code)
);

ALTER TABLE brand
    ADD CONSTRAINT UK_CODE UNIQUE (code);
```
- ITEM
```
CREATE TABLE item
(
    seq         BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    inserted_at TIMESTAMP,
    inserted_id VARCHAR(255),
    updated_at  TIMESTAMP,
    updated_id  VARCHAR(255),
    brand       VARCHAR(255)                            NOT NULL,
    category    SMALLINT                                NOT NULL,
    price       DECIMAL                                 NOT NULL,
    CONSTRAINT pk_item PRIMARY KEY (seq)
);

ALTER TABLE item
    ADD CONSTRAINT FK_ITEM_ON_BRAND FOREIGN KEY (brand) REFERENCES brand (code);
```
