package musinsa.bob.main.service;

import lombok.RequiredArgsConstructor;
import musinsa.bob.main.config.exception.AppException;
import musinsa.bob.main.entity.BrandEntity;
import musinsa.bob.main.enums.exception.BrandException;
import musinsa.bob.main.mapper.BrandConverter;
import musinsa.bob.main.repository.jpa.BrandRepository;
import musinsa.bob.main.vo.brand.BrandVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BrandService {


    private final BrandRepository brandRepository;
    private final BrandConverter brandConverter;

    @Transactional(readOnly = true)
    protected Optional<BrandEntity> findBrandByCode(String code) {
        return brandRepository.findByCode(code);
    }

    @Transactional(readOnly = true)
    public BrandEntity findByCode(String name, AppException exception) {

        Optional<BrandEntity> optionalBrandEntity =  this.findBrandByCode(name);
        if (exception != null) {
            optionalBrandEntity.ifPresent((brand) -> {
                throw exception;
            });
        }

        return optionalBrandEntity.orElseGet(() -> null);

    }

    @Transactional(readOnly = true)
    public BrandVo find(String code) {
        BrandEntity brandEntity = this.findBrandByCode(code).orElseThrow(BrandException.BRAND_NOT_FOUND::throwErrors);
        return brandConverter.toDto(brandEntity);

    }

    @Transactional()
    public BrandVo register(BrandVo brandVo) {

        findByCode(brandVo.getCode(), BrandException.ALREADY_EXISTS.throwErrors());

        BrandEntity brandEntity = brandConverter.toEntity(brandVo);
        return brandConverter.toDto( brandRepository.saveAndFlush(brandEntity));
    }

    @Transactional()
    public BrandVo update(BrandVo brandVo) {
        BrandEntity brandEntity = this.findBrandByCode(brandVo.getCode()).orElseThrow(BrandException.BRAND_NOT_FOUND::throwErrors);

        brandConverter.updateBrandFromDto(brandVo, brandEntity);
        return brandConverter.toDto(brandRepository.saveAndFlush(brandEntity));
    }

    @Transactional()
    public void delete(String code) {
        BrandEntity brandEntity = this.findBrandByCode(code).orElseThrow(BrandException.BRAND_NOT_FOUND::throwErrors);
        brandRepository.delete(brandEntity);
    }

}
