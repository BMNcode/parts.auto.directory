package org.bmn.parts.auto.directory.repository;

import org.bmn.parts.auto.directory.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
    boolean existsBrandByBrand(String brand);
    Brand findByBrand(String brand);
}
