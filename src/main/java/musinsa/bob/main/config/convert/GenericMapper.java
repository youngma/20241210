package musinsa.bob.main.config.convert;

import org.mapstruct.BeanMapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;


public interface GenericMapper<Dto, Entity> {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Dto toDto(Entity e);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Entity toEntity(Dto d);

    List<Dto> toDtoList(List<Entity> e);

    List<Entity> toEntities(List<Dto> d);

}