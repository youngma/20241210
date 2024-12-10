package musinsa.bob.main.vo.item.request;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import musinsa.bob.main.enums.Category;
import musinsa.bob.main.enums.exception.CategoryException;

import java.math.BigDecimal;

@Data
public class RegisterItemVo {

    @NotBlank(message = "필수값 입니다.")
    private String brand;

    @NotNull(message = "필수값 입니다.")
    private Category category;

    @Min(0)
    private BigDecimal price;

    public void setCategory(String category) {
        this.category = Category.findByNameOptional(category).orElseThrow(CategoryException.NOT_FOUND::throwErrors);
    }
}

