package musinsa.bob.main.vo.brand.resp;

import com.fasterxml.jackson.annotation.JsonFormat;
import musinsa.bob.main.vo.brand.BrandVo;

import java.time.LocalDateTime;


public record BrandRespVo (
        String code,
        String name,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
        LocalDateTime insertedAt,

        String insertedId,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
        LocalDateTime updatedAt,

        String updatedId
) {

    public BrandRespVo (BrandVo brand) {
        this(brand.getCode(), brand.getName(), brand.getInsertedAt(), brand.getInsertedId(), brand.getUpdatedAt(), brand.getUpdatedId() );
    }
}
