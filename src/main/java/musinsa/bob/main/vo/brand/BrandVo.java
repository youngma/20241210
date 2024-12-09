package musinsa.bob.main.vo.brand;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import musinsa.bob.main.vo.brand.request.RequestBrandVo;
import musinsa.bob.main.vo.brand.resp.BrandRespVo;

import java.time.LocalDateTime;

@Data
public class BrandVo {

    private String code;
    private String name;

    public static BrandVo of(String name) {
        BrandVo brand = new BrandVo();
        brand.name = name;
        return brand;
    }

    public static BrandVo of(String code, String name) {
        BrandVo brand = new BrandVo();
        brand.code = code;
        brand.name = name;
        return brand;
    }

    public static BrandVo of(RequestBrandVo brandReqVo) {
        return BrandVo.of(brandReqVo.getCode(), brandReqVo.getName());
    }

    /**
     * 등록 일자
     */
    @JsonIgnore
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    protected LocalDateTime insertedAt;

    /**
     * 등록자
     */
    @JsonIgnore
    protected String insertedId;


    /**
     * 수정 일자
     */
    @JsonIgnore
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    protected LocalDateTime updatedAt;


    /**
     * 수정자
     */
    @JsonIgnore
    protected String updatedId;

    public BrandRespVo toResp() {
        return new BrandRespVo(this);
    }


}
