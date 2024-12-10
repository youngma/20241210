package musinsa.bob.main.repository.querydsl;

import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.SubQueryExpression;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import musinsa.bob.main.entity.QBrandEntity;
import musinsa.bob.main.entity.QItemEntity;
import musinsa.bob.main.enums.Category;
import musinsa.bob.main.enums.exception.BrandException;
import musinsa.bob.main.vo.item.resp.BrandPriceVo;
import musinsa.bob.main.vo.item.resp.CategoryMinPriceVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class QItemRepository {

    private final EntityManager entityManager;

    private final JPAQueryFactory queryFactory;

    public List<CategoryMinPriceVo> findMinPriceByCategory() {

        QItemEntity item = QItemEntity.itemEntity;
        QBrandEntity brand = QBrandEntity.brandEntity;
        QItemEntity subItem = new QItemEntity("subItem");


        // 서브쿼리로 각 카테고리별 최저가 조회
        SubQueryExpression<Tuple> subQuery = JPAExpressions
                .select(subItem.category, subItem.price.min())
                .from(subItem)
                .groupBy(subItem.category);

        return queryFactory
                .select(Projections.constructor(CategoryMinPriceVo.class,
                        item.category,
                        item.price,
                        brand.code))
                .from(item)
                .innerJoin(item.brandEntity, brand)
                .where(item.category.in(
                        JPAExpressions
                            .select(subItem.category)
                            .from(subItem)
                            .groupBy(subItem.category)
                            .having(subItem.price.min().eq(item.price))
                ))
                .orderBy(item.category.asc())
                .fetch();

    }

    public List<CategoryMinPriceVo> findMinPriceByBrand() {

        QItemEntity item = QItemEntity.itemEntity;
        QBrandEntity brand = QBrandEntity.brandEntity;

        CategoryMinPriceVo selected =  queryFactory
                .select(Projections.constructor(CategoryMinPriceVo.class,
                    brand.code,
                    item.price.sum()
                ))
                .from(item)
                .innerJoin(item.brandEntity, brand)
                .groupBy(item.brandEntity.code)
                .orderBy(item.price.sum().asc())
                .stream().findFirst().orElseThrow(BrandException.BRAND_NOT_FOUND::throwErrors);


        return queryFactory
                .select(Projections.constructor(CategoryMinPriceVo.class,
                        item.category,
                        item.price,
                        brand.code))
                .from(item)
                .innerJoin(item.brandEntity, brand)
                .where(
                        item.brandEntity.code.eq(selected.brand())
                )
                .fetch();

    }


    public BrandPriceVo findMaxPriceByCategory(Category category) {

        QItemEntity item = QItemEntity.itemEntity;
        QBrandEntity brand = QBrandEntity.brandEntity;

        return queryFactory
                .select(Projections.constructor(BrandPriceVo.class,
                        brand.code,
                        item.price
                ))
                .from(item)
                .innerJoin(item.brandEntity, brand)
                .where(item.category.eq(category))
                .orderBy(item.price.desc())
                .fetchFirst();

    }

    public BrandPriceVo findMinPriceByCategory(Category category) {

        QItemEntity item = QItemEntity.itemEntity;
        QBrandEntity brand = QBrandEntity.brandEntity;

        return queryFactory
                .select(Projections.constructor(BrandPriceVo.class,
                        brand.code,
                        item.price
                ))
                .from(item)
                .innerJoin(item.brandEntity, brand)
                .where(item.category.eq(category))
                .orderBy(item.price.asc())
                .fetchFirst();

    }

}
