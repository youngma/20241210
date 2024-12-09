package musinsa.bob.main.repository.jpa;

import musinsa.bob.main.entity.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;


public interface BrandRepository extends JpaRepository<BrandEntity, Long>, JpaSpecificationExecutor<BrandEntity> {

    Optional<BrandEntity> findByCode(String code);
}
