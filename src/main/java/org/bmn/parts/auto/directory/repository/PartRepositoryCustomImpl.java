package org.bmn.parts.auto.directory.repository;

import org.bmn.parts.auto.directory.dto.Operation;
import org.bmn.parts.auto.directory.model.Brand;
import org.bmn.parts.auto.directory.model.Category;
import org.bmn.parts.auto.directory.model.Model;
import org.bmn.parts.auto.directory.model.Part;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PartRepositoryCustomImpl implements PartRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Part> findByParams(String article,
                                   String partName,
                                   String category,
                                   String model,
                                   String brand,
                                   Operation operation) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Part> c = cb.createQuery(Part.class);

        Root<Part> part = c.from(Part.class);

        Join<Part, Model> modelJoin = part.join("models", JoinType.INNER);

        List<Predicate> predicates = new ArrayList<>();

        if(article != null) {
            predicates.add(cb.equal(part.get("article"), article));
        }

        if(partName != null) {
            predicates.add(cb.equal(part.get("partName"), partName));
        }

        if(category != null) {
            Path<Category> categoryPath = part.get("category");
            Path<String> categoryNamePath = categoryPath.get("category");
            predicates.add(cb.equal(categoryNamePath, category));
        }

        if(model != null) {
            predicates.add(cb.equal(modelJoin.get("model"), model));
        }

        if(brand != null) {
            Path<Brand> brandPath = modelJoin.get("brand");
            Path<String> brandNamePath = brandPath.get("brand");
            predicates.add(cb.equal(brandNamePath, brand));
        }

        Predicate predicate = null;

        if (Operation.OR == operation) {
            predicate = cb.or(predicates.toArray(new Predicate[0]));
        } else {
            predicate = cb.and(predicates.toArray(new Predicate[0]));
        }

        c.where(predicate);

        return entityManager.createQuery(c.distinct(true)).getResultList();
    }
}
