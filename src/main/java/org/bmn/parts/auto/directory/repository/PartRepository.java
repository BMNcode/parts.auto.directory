package org.bmn.parts.auto.directory.repository;

import org.bmn.parts.auto.directory.dto.Operation;
import org.bmn.parts.auto.directory.model.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public interface PartRepository extends JpaRepository<Part, Long> {
    
//    EntityManager entityManager = null;
//    @Query(
//            value = "SELECT part.id, part.article, part.part_name, part.model_id, part.category_id " +
//                    "FROM part " +
//                    "JOIN category ON part.category_id = category.id " +
//                    "JOIN model ON part.model_id = model.id " +
//                    "JOIN brand ON model.brand_id = brand.id " +
//                    "WHERE ?1",
//            nativeQuery = true)
    
    

//    List<Part> findAllByParams(Boolean condition);
    
//    default
}
