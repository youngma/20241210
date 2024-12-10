package musinsa.bob.main.mapper;

import musinsa.bob.main.config.convert.GenericMapper;
import musinsa.bob.main.entity.ItemEntity;
import musinsa.bob.main.vo.item.ItemVo;
import musinsa.bob.main.vo.item.resp.ItemRespVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public  interface ItemConverter extends GenericMapper<ItemVo, ItemEntity> {


    @Mapping(target = "brandVo", source = "brandEntity")
    @Override
    ItemVo toDto(ItemEntity e);

    @Mapping(target = "brandEntity", ignore = true)
    @Override
    ItemEntity toEntity(ItemVo d);

    @Override
    List<ItemVo> toDtoList(List<ItemEntity> e);

    @Override
    List<ItemEntity> toEntities(List<ItemVo> d);
}
