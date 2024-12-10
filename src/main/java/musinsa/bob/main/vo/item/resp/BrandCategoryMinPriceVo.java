package musinsa.bob.main.vo.item.resp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import musinsa.bob.main.config.jsonConfig.MoneySerializer;

import java.math.BigDecimal;
import java.util.List;

public record BrandCategoryMinPriceVo(
    String name,
    List<CategoryPriceVo> items,
    @JsonSerialize(using = MoneySerializer.class) BigDecimal total
) {

    public BrandCategoryMinPriceVo(List<CategoryMinPriceVo> brandItems) {
        this(brandItems.get(0).brand(),
                brandItems.stream()
                        .map(item -> new CategoryPriceVo(item.category(), item.minPrice()))
                        .toList(),
                brandItems.stream()
                        .map(CategoryMinPriceVo::minPrice)
                        .reduce(BigDecimal.ZERO, BigDecimal::add));
    }
}
