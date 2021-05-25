package org.bmn.parts.auto.directory.repository;

import org.bmn.parts.auto.directory.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    boolean existsCategoryByCategory(String category);
    Category findByCategory(String category);
}
