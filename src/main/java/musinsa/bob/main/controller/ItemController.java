package musinsa.bob.main.controller;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import musinsa.bob.main.config.vo.RespVo;
import musinsa.bob.main.enums.Category;
import musinsa.bob.main.enums.exception.CategoryException;
import musinsa.bob.main.service.ItemService;
import musinsa.bob.main.vo.item.request.RegisterItemVo;
import musinsa.bob.main.vo.item.request.UpdateItemVo;
import musinsa.bob.main.vo.item.resp.BrandCategoryMinPriceVo;
import musinsa.bob.main.vo.item.resp.CategoryMinPriceVo;
import musinsa.bob.main.vo.item.resp.ItemRespVo;
import musinsa.bob.main.vo.item.resp.PriceByCategoryVo;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/item")
@RestController
@Slf4j
@Validated
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/group/category/price/min")
    public RespVo<List<CategoryMinPriceVo>> getItemByMinPriceCategory() {
        return new RespVo<>(itemService.findMinPriceByCategory());
    }


    @GetMapping("/group/brand/price/min")
    public RespVo<BrandCategoryMinPriceVo> getItemByMinPriceBrand() {
        return new RespVo<>(itemService.findMinPriceByBrand());
    }

    @GetMapping("/brand/price/{category}")
    public RespVo<PriceByCategoryVo> getItemByMinPriceBrand(
            @PathVariable("category") String name

    ) {
        Category  category = Category.findByNameOptional(name).orElseThrow(CategoryException.NOT_FOUND::throwErrors);
        return new RespVo<>(itemService.findMinMaxPriceBrandByCategory(category));
    }

    @PostMapping
    public RespVo<ItemRespVo> add(@RequestBody @Validated @NotNull RegisterItemVo requestItemVo) {
        return new RespVo<>(itemService.register(requestItemVo));
    }

    @PutMapping
    public RespVo<ItemRespVo> update(@RequestBody @Validated @NotNull UpdateItemVo updateItemVo) {
        return new RespVo<>(itemService.update(updateItemVo));
    }

    @DeleteMapping("{seq}")
    public RespVo<String> delete(
            @NotNull(message = "필수값 입니다.")
            @PathVariable("seq") Long seq
    ) {
        itemService.delete(seq);
        return new RespVo<>("처리 되었습니다.");

    }
}
