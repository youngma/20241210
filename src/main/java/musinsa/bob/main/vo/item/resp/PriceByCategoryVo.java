package musinsa.bob.main.vo.item.resp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import musinsa.bob.main.config.jsonConfig.MoneySerializer;
import musinsa.bob.main.enums.Category;

import java.math.BigDecimal;

public record PriceByCategoryVo(
        String category,
        BrandPriceVo maxBrand,
        BrandPriceVo minBrand
) {

}
