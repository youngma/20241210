package musinsa.bob.main.config.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public record RespVo<T> (

        @JsonProperty("message")
        @JsonInclude(JsonInclude.Include.NON_NULL)
        String message,

        @JsonProperty("code")
        @JsonInclude(JsonInclude.Include.NON_NULL)
        Integer code,

        @JsonInclude(JsonInclude.Include.NON_NULL)
        @JsonProperty("result")  T value
        ) {

    public RespVo(String message, Integer code) {
        this(message, code, null);
    }

    public RespVo(T value) {
        this(null, 200, value);
    }
}

