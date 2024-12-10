package musinsa.bob.main.vo.item.resp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import musinsa.bob.main.config.jsonConfig.MoneySerializer;
import musinsa.bob.main.enums.Category;

import java.math.BigDecimal;

public record CategoryMinMaxItemVo(
        String category,
        @JsonSerialize(using = MoneySerializer.class) BigDecimal minPrice,
        String brandName
) {

    public CategoryMinMaxItemVo(Category category, BigDecimal minPrice, String brandName) {
        this(category.getDisplayName(), minPrice, brandName);
    }

    public CategoryMinMaxItemVo(String brandName, BigDecimal minPrice) {
        this("-" , minPrice, brandName);
    }
}
