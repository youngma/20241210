package musinsa.bob.main.vo.item.resp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import musinsa.bob.main.config.jsonConfig.MoneySerializer;
import musinsa.bob.main.enums.Category;

import java.math.BigDecimal;

public record CategoryPriceVo(
        String category,
        @JsonSerialize(using = MoneySerializer.class) BigDecimal price
) {

    public CategoryPriceVo(Category category, BigDecimal minPrice) {
        this(category.getDisplayName(), minPrice);
    }
}