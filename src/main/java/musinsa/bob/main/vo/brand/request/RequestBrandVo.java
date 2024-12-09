package musinsa.bob.main.vo.brand.request;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RequestBrandVo {

    @NotBlank(message = "필수값 입니다.")
    private String code;

    @NotBlank(message = "필수값 입니다.")
    private String name;

}
