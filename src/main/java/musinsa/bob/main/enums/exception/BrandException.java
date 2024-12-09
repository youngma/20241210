package musinsa.bob.main.enums.exception;


import musinsa.bob.main.config.exception.AppException;

public enum BrandException {

    BRAND_NOT_FOUND("브랜드 정보를 찾을 수 없습니다."),
    ALREADY_EXISTS("이미 등록된 브랜드입니다."),
    ;

    private String message;

    BrandException(String message) {
        this.message = message;
    }


    public AppException throwErrors() {
        return new AppException(this.message);
    }

}
