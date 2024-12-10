package musinsa.bob.main.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import musinsa.bob.main.config.jpa.BaseEntity;
import musinsa.bob.main.enums.Category;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 사용자 Entity
 */
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "ITEM")
@DynamicUpdate
public class ItemEntity extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "SEQ", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BRAND", nullable = false)
    @ToString.Exclude
    private BrandEntity brandEntity;

    @Column(name = "CATEGORY", nullable = false)
    private Category category;

    @Column(name = "PRICE", nullable = false)
    private BigDecimal price;


    public static ItemEntity of(BrandEntity brandEntity, Category category, BigDecimal price) {
        ItemEntity itemEntity = new ItemEntity();

        itemEntity.brandEntity = brandEntity;
        itemEntity.category = category;
        itemEntity.price = price;

        return itemEntity;
    }

    public void update(BrandEntity brandEntity, Category category, BigDecimal price) {
        this.brandEntity = brandEntity;
        this.category = category;
        this.price = price;
    }
}
