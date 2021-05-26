package org.bmn.parts.auto.directory.repository;

import org.bmn.parts.auto.directory.model.Part;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartRepository extends JpaRepository<Part, Long>, PartRepositoryCustom {
}
