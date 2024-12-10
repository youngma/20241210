package musinsa.bob.main.service;

import lombok.RequiredArgsConstructor;
import musinsa.bob.main.entity.BrandEntity;
import musinsa.bob.main.entity.ItemEntity;
import musinsa.bob.main.enums.Category;
import musinsa.bob.main.enums.exception.BrandException;
import musinsa.bob.main.enums.exception.ItemException;
import musinsa.bob.main.mapper.ItemConverter;
import musinsa.bob.main.repository.jpa.ItemRepository;
import musinsa.bob.main.repository.querydsl.QItemRepository;
import musinsa.bob.main.vo.item.request.RegisterItemVo;
import musinsa.bob.main.vo.item.request.UpdateItemVo;
import musinsa.bob.main.vo.item.resp.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final BrandService brandService;

    private final ItemRepository itemRepository;
    private final QItemRepository qItemRepository;


    private final ItemConverter itemConverter;


    public List<CategoryMinPriceVo> findMinPriceByCategory() {
        return qItemRepository.findMinPriceByCategory();
    }

    public BrandCategoryMinPriceVo findMinPriceByBrand() {
        return new BrandCategoryMinPriceVo(qItemRepository.findMinPriceByBrand());
    }

    public PriceByCategoryVo findMinMaxPriceBrandByCategory(Category category) {

        BrandPriceVo maxPriceByBrand = qItemRepository.findMaxPriceByCategory(category);
        BrandPriceVo minPriceByBrand = qItemRepository.findMinPriceByCategory(category);

        return new PriceByCategoryVo(category.getKoreanName(), maxPriceByBrand, minPriceByBrand );

    }



    @Transactional(readOnly = true)
    protected Optional<ItemEntity> findItem(Long seq) {
        return itemRepository.findById(seq);
    }



    @Transactional
    public ItemRespVo register(RegisterItemVo itemVo) {

        BrandEntity brandEntity = brandService.findBrandByCode(itemVo.getBrand()).orElseThrow(BrandException.BRAND_NOT_FOUND::throwErrors);

        Category category = itemVo.getCategory();

        ItemEntity itemEntity = ItemEntity.of(brandEntity, category, itemVo.getPrice());

        return itemConverter
                .toDto(itemRepository.save(itemEntity))
                .toResp();

    }


    @Transactional
    public ItemRespVo update(UpdateItemVo itemVo) {

        ItemEntity itemEntity = this.findItem(itemVo.getSeq()).orElseThrow(ItemException.NOT_FOUND::throwErrors);
        BrandEntity brandEntity = brandService.findBrandByCode(itemVo.getBrand()).orElseThrow(BrandException.BRAND_NOT_FOUND::throwErrors);

        itemEntity.update(brandEntity, itemVo.getCategory(), itemVo.getPrice());

        return itemConverter
                .toDto(itemRepository.save(itemEntity))
                .toResp();

    }

    @Transactional
    public void delete(Long seq) {
        ItemEntity itemEntity = this.findItem(seq).orElseThrow(ItemException.NOT_FOUND::throwErrors);
        itemRepository.delete(itemEntity);
    }

}
