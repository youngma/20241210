package musinsa.bob.main.controller;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import musinsa.bob.main.config.vo.RespVo;
import musinsa.bob.main.service.BrandService;
import musinsa.bob.main.vo.brand.BrandVo;
import musinsa.bob.main.vo.brand.request.RequestBrandVo;
import musinsa.bob.main.vo.brand.resp.BrandRespVo;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/brand")
@RestController
@Slf4j
@Validated
public class BrandController {

    private final BrandService brandService;

    @PostMapping("")
    public RespVo<BrandRespVo> add(@RequestBody @Validated @NotNull RequestBrandVo requestBrandVo) {
        BrandVo brandVo = brandService.register(BrandVo.of(requestBrandVo));
        return new RespVo<>(brandVo.toResp());
    }

    @GetMapping("/{code}")
    public RespVo<BrandRespVo> find(
            @NotBlank(message = "필수값 입니다.")
            @PathVariable("code") String code
    ) {
        BrandVo brandVo = brandService.find(code);
        return new RespVo<>(brandVo.toResp());
    }

    @PutMapping("")
    public RespVo<BrandRespVo> update(
            @RequestBody @Validated @NotNull RequestBrandVo requestBrandVo
    ) {
        BrandVo brandVo = brandService.update(BrandVo.of(requestBrandVo));
        return new RespVo<>(brandVo.toResp());
    }

    @DeleteMapping("/{code}")
    public RespVo<String> delete(
            @NotBlank(message = "필수값 입니다.")
            @PathVariable("code") String code
    ) {
        brandService.delete(code);
        return new RespVo<>("처리 되었습니다.");
    }
}
