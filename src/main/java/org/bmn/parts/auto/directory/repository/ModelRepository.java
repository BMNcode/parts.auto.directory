package org.bmn.parts.auto.directory.repository;

import org.bmn.parts.auto.directory.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Long> {
    boolean existsModelByModel(String model);
    Model findByModel(String model);
}
