package musinsa.bob.main.vo.item;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import musinsa.bob.main.enums.Category;
import musinsa.bob.main.enums.exception.CategoryException;
import musinsa.bob.main.vo.brand.BrandVo;
import musinsa.bob.main.vo.brand.resp.BrandRespVo;
import musinsa.bob.main.vo.item.resp.ItemRespVo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ItemVo {

    private Long seq;

    private BrandVo brandVo;

    private Category category;

    private BigDecimal price;


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


    public ItemRespVo toResp() {
        return new ItemRespVo(this);
    }

}

