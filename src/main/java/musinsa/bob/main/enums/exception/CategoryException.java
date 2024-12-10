package musinsa.bob.main.enums.exception;


import musinsa.bob.main.config.exception.AppException;

public enum CategoryException {

    NOT_FOUND("카테고리 정보를 찾을 수 없습니다."),
    ;

    private final String message;

    CategoryException(String message) {
        this.message = message;
    }


    public AppException throwErrors() {
        return new AppException(this.message);
    }

}
