package musinsa.bob.main.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import musinsa.bob.main.config.jpa.BaseEntity;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serial;
import java.io.Serializable;

/**
 * 사용자 Entity
 */
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "BRAND",
    uniqueConstraints = {
    @UniqueConstraint(
            name = "UK_CODE",  // 제약조건 이름 지정
            columnNames = {"CODE"}
    )
}
)
@DynamicUpdate
public class BrandEntity extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "CODE", nullable = false)
    private String code;

    @Column(name = "BRAND_NAME", nullable = false)
    private String name;


    public static BrandEntity of(String code) {
        BrandEntity brand = new BrandEntity();
        brand.code = code;
        return brand;
    }

    public static BrandEntity ofAutoName(String code) {
        BrandEntity brand = new BrandEntity();
        brand.code = code;
        brand.name = code.concat("_").concat("Name");
        return brand;
    }

}
