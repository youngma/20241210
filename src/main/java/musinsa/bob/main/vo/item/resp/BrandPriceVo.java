package musinsa.bob.main.vo.item.resp;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import musinsa.bob.main.config.jsonConfig.MoneySerializer;

import java.math.BigDecimal;

public record BrandPriceVo(
        String brand,
        @JsonSerialize(using = MoneySerializer.class) BigDecimal minPrice
) {

}
