package musinsa.bob.main.config.init;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import musinsa.bob.main.entity.BrandEntity;
import musinsa.bob.main.entity.ItemEntity;
import musinsa.bob.main.enums.Category;
import musinsa.bob.main.repository.jpa.BrandRepository;
import musinsa.bob.main.repository.jpa.ItemRepository;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Configuration
public class InitDataGenerator {

    private final BrandRepository brandRepository;
    private final ItemRepository itemRepository;

    @PostConstruct
    public void initData() {
        List<BrandEntity> brandEntities = insertBrand();
        insertItem(brandEntities);
    }

    public List<BrandEntity> insertBrand() {
        List<BrandEntity> brandEntities =   Stream.of("A", "B", "C", "D", "E", "F", "G", "H", "I" ).map(
                BrandEntity::ofAutoName
        ).toList();
        return brandRepository.saveAll(brandEntities);
    }


    public void insertItem(List<BrandEntity> brandEntities) {

        HashMap<String, HashMap<Category, BigDecimal>> itemOriginData = new HashMap<>();

        // 브랜드 A 데이터
        HashMap<Category, BigDecimal> brandA = new HashMap<>();
        brandA.put(Category.TOP, new BigDecimal("11200"));
        brandA.put(Category.OUTER, new BigDecimal("5500"));
        brandA.put(Category.PANTS, new BigDecimal("4200"));
        brandA.put(Category.SNEAKERS, new BigDecimal("9000"));
        brandA.put(Category.BAG, new BigDecimal("2000"));
        brandA.put(Category.HAT, new BigDecimal("1700"));
        brandA.put(Category.SOCKS, new BigDecimal("1800"));
        brandA.put(Category.ACCESSORIES, new BigDecimal("2300"));
        itemOriginData.put("A", brandA);

        // 브랜드 B 데이터
        HashMap<Category, BigDecimal> brandB = new HashMap<>();
        brandB.put(Category.TOP, new BigDecimal("10500"));
        brandB.put(Category.OUTER, new BigDecimal("5900"));
        brandB.put(Category.PANTS, new BigDecimal("3800"));
        brandB.put(Category.SNEAKERS, new BigDecimal("9100"));
        brandB.put(Category.BAG, new BigDecimal("2100"));
        brandB.put(Category.HAT, new BigDecimal("2000"));
        brandB.put(Category.SOCKS, new BigDecimal("2000"));
        brandB.put(Category.ACCESSORIES, new BigDecimal("2200"));
        itemOriginData.put("B", brandB);

        // 브랜드 C 데이터
        HashMap<Category, BigDecimal> brandC = new HashMap<>();
        brandC.put(Category.TOP, new BigDecimal("10000"));
        brandC.put(Category.OUTER, new BigDecimal("6200"));
        brandC.put(Category.PANTS, new BigDecimal("3300"));
        brandC.put(Category.SNEAKERS, new BigDecimal("9200"));
        brandC.put(Category.BAG, new BigDecimal("2200"));
        brandC.put(Category.HAT, new BigDecimal("1900"));
        brandC.put(Category.SOCKS, new BigDecimal("2200"));
        brandC.put(Category.ACCESSORIES, new BigDecimal("2100"));
        itemOriginData.put("C", brandC);

        // 브랜드 D 데이터
        HashMap<Category, BigDecimal> brandD = new HashMap<>();
        brandD.put(Category.TOP, new BigDecimal("10100"));
        brandD.put(Category.OUTER, new BigDecimal("5100"));
        brandD.put(Category.PANTS, new BigDecimal("3000"));
        brandD.put(Category.SNEAKERS, new BigDecimal("9500"));
        brandD.put(Category.BAG, new BigDecimal("2500"));
        brandD.put(Category.HAT, new BigDecimal("1500"));
        brandD.put(Category.SOCKS, new BigDecimal("2400"));
        brandD.put(Category.ACCESSORIES, new BigDecimal("2000"));
        itemOriginData.put("D", brandD);

        // 브랜드 E 데이터
        HashMap<Category, BigDecimal> brandE = new HashMap<>();
        brandE.put(Category.TOP, new BigDecimal("10700"));
        brandE.put(Category.OUTER, new BigDecimal("5000"));
        brandE.put(Category.PANTS, new BigDecimal("3800"));
        brandE.put(Category.SNEAKERS, new BigDecimal("9900"));
        brandE.put(Category.BAG, new BigDecimal("2300"));
        brandE.put(Category.HAT, new BigDecimal("1800"));
        brandE.put(Category.SOCKS, new BigDecimal("2100"));
        brandE.put(Category.ACCESSORIES, new BigDecimal("2100"));
        itemOriginData.put("E", brandE);

        // 브랜드 F 데이터
        HashMap<Category, BigDecimal> brandF = new HashMap<>();
        brandF.put(Category.TOP, new BigDecimal("11200"));
        brandF.put(Category.OUTER, new BigDecimal("7200"));
        brandF.put(Category.PANTS, new BigDecimal("4000"));
        brandF.put(Category.SNEAKERS, new BigDecimal("9300"));
        brandF.put(Category.BAG, new BigDecimal("2100"));
        brandF.put(Category.HAT, new BigDecimal("1600"));
        brandF.put(Category.SOCKS, new BigDecimal("2300"));
        brandF.put(Category.ACCESSORIES, new BigDecimal("1900"));
        itemOriginData.put("F", brandF);

        // 브랜드 G 데이터
        HashMap<Category, BigDecimal> brandG = new HashMap<>();
        brandG.put(Category.TOP, new BigDecimal("10500"));
        brandG.put(Category.OUTER, new BigDecimal("5800"));
        brandG.put(Category.PANTS, new BigDecimal("3900"));
        brandG.put(Category.SNEAKERS, new BigDecimal("9000"));
        brandG.put(Category.BAG, new BigDecimal("2200"));
        brandG.put(Category.HAT, new BigDecimal("1700"));
        brandG.put(Category.SOCKS, new BigDecimal("2100"));
        brandG.put(Category.ACCESSORIES, new BigDecimal("2000"));
        itemOriginData.put("G", brandG);

        // 브랜드 H 데이터
        HashMap<Category, BigDecimal> brandH = new HashMap<>();
        brandH.put(Category.TOP, new BigDecimal("10800"));
        brandH.put(Category.OUTER, new BigDecimal("6300"));
        brandH.put(Category.PANTS, new BigDecimal("3100"));
        brandH.put(Category.SNEAKERS, new BigDecimal("9700"));
        brandH.put(Category.BAG, new BigDecimal("2100"));
        brandH.put(Category.HAT, new BigDecimal("1600"));
        brandH.put(Category.SOCKS, new BigDecimal("2000"));
        brandH.put(Category.ACCESSORIES, new BigDecimal("2000"));
        itemOriginData.put("H", brandH);

        // 브랜드 I 데이터
        HashMap<Category, BigDecimal> brandI = new HashMap<>();
        brandI.put(Category.TOP, new BigDecimal("11400"));
        brandI.put(Category.OUTER, new BigDecimal("6700"));
        brandI.put(Category.PANTS, new BigDecimal("3200"));
        brandI.put(Category.SNEAKERS, new BigDecimal("9500"));
        brandI.put(Category.BAG, new BigDecimal("2400"));
        brandI.put(Category.HAT, new BigDecimal("1700"));
        brandI.put(Category.SOCKS, new BigDecimal("1700"));
        brandI.put(Category.ACCESSORIES, new BigDecimal("2400"));
        itemOriginData.put("I", brandI);


        List<ItemEntity> allItems = brandEntities.stream()
                .flatMap(brandEntry -> {
                    String brandCode = brandEntry.getCode();

                    return itemOriginData.get(brandCode).entrySet().stream()
                            .map(categoryEntry -> ItemEntity.of(
                                    brandEntry,
                                    categoryEntry.getKey(),
                                    categoryEntry.getValue()
                            ));

                })
                .toList();


        itemRepository.saveAll(allItems);
    }


}
