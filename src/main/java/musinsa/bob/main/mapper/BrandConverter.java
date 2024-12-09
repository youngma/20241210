package musinsa.bob.main.mapper;

import musinsa.bob.main.config.convert.GenericMapper;
import musinsa.bob.main.entity.BrandEntity;
import musinsa.bob.main.vo.brand.BrandVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BrandConverter extends GenericMapper<BrandVo, BrandEntity> {

    @Mapping(target = "code", ignore = true)  // ID 필드는 업데이트하지 않음
    @Mapping(target = "insertedAt", ignore = true)
    @Mapping(target = "insertedId", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "updatedId", ignore = true)
    void updateBrandFromDto(BrandVo dto, @MappingTarget BrandEntity entity);

}
