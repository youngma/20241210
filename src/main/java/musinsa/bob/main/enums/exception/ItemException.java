package musinsa.bob.main.enums.exception;


import musinsa.bob.main.config.exception.AppException;

public enum ItemException {

    NOT_FOUND("상품 정보를 찾을 수 없습니다."),
    ;

    private final String message;

    ItemException(String message) {
        this.message = message;
    }


    public AppException throwErrors() {
        return new AppException(this.message);
    }

}
