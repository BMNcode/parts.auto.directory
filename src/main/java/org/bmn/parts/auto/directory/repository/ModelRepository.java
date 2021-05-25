package org.bmn.parts.auto.directory.repository;

import org.bmn.parts.auto.directory.model.Brand;
import org.bmn.parts.auto.directory.model.Model;
import org.bmn.parts.auto.directory.model.Part;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModelRepository extends JpaRepository<Model, Long> {
    boolean existsModelByModel(String model);
    Model findByModel(String model);
}
