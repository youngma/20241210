package musinsa.bob.main.vo.item.resp;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import musinsa.bob.main.config.jsonConfig.MoneySerializer;
import musinsa.bob.main.vo.brand.BrandVo;
import musinsa.bob.main.vo.item.ItemVo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ItemRespVo(
        Long seq,
        BrandVo brand,
        String category,
        @JsonSerialize(using = MoneySerializer.class) BigDecimal price,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
        LocalDateTime insertedAt,

        String insertedId,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
        LocalDateTime updatedAt,

        String updatedId
) {


    public ItemRespVo(ItemVo itemVo) {
        this(itemVo.getSeq(), itemVo.getBrandVo(), itemVo.getCategory().getDisplayName(), itemVo.getPrice(),
                itemVo.getInsertedAt(), itemVo.getInsertedId(), itemVo.getUpdatedAt(), itemVo.getUpdatedId());
    }

}

