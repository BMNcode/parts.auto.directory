package org.bmn.parts.auto.directory.repository;

import org.bmn.parts.auto.directory.dto.Operation;
import org.bmn.parts.auto.directory.model.*;
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

//    @Override
//    public List<Part> findByParams(String article,
//                                       String partName,
//                                       String category,
//                                       String model,
//                                       String brand,
//                                       Operation operation) {
//
//        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//        CriteriaQuery<Part> c = cb.createQuery(Part.class);
//        Root<Part> part = c.from(Part.class);
//
//        List<Predicate> predicates = new ArrayList<>();
//
//        if(article != null) {
//            predicates.add(cb.equal(part.get("article"), article));
//        }
//
//        if(partName != null) {
//            predicates.add(cb.equal(part.get("partName"), partName));
//        }
//
//        if(category != null) {
//            Path<Category> categoryPath = part.get("category");
//            Path<String> categoryNamePath = categoryPath.get("name");
//            predicates.add(cb.equal(categoryNamePath, category));
//        }
//
//        if(model != null) {
//            Path<Model> modelPath = part.get("model");
//            Path<String> modelNamePath = modelPath.get("name");
//            predicates.add(cb.equal(modelNamePath, model));
//        }
//
//        if(brand != null) {
//            Path<Model> modelPath = part.get("model");
//            Path<Brand> brandPath = modelPath.get("brand");
//            Path<String> brandNamePath = brandPath.get("name");
//            predicates.add(cb.equal(brandNamePath, brand));
//        }
//
//        Predicate predicate = null;
//
//        if (Operation.AND == operation) {
//            predicate = cb.and(predicates.toArray(new Predicate[0]));
//        } else {
//            predicate = cb.or(predicates.toArray(new Predicate[0]));
//        }
//
//        c.where(predicate);
//
//        return entityManager.createQuery(c).getResultList();
//    }

//    Criteria c = session.createCriteria(ItemHolder.class, "itemHolder");
//c.createAlias("itemHolder.items", "item");
//c.add(Restrictions.eq("item.id", theItemId);

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

        List<Predicate> predicates = new ArrayList<>();

        if(article != null) {
            predicates.add(cb.equal(part.get("article"), article));
        }

        if(partName != null) {
            predicates.add(cb.equal(part.get("partName"), partName));
        }

        if(category != null) {
            Path<Category> categoryPath = part.get("category");
            Path<String> categoryNamePath = categoryPath.get("name");
            predicates.add(cb.equal(categoryNamePath, category));
        }

        if(model != null) {
            Path<List<Model>> modelPath = part.get("models");
            Path<List<String>> modelNamePath = modelPath.get("model");
            predicates.add(cb.equal(modelNamePath, model));
        }

        if(brand != null) {
            Path<Model> modelPath = part.get("model");
            Path<Brand> brandPath = modelPath.get("brand");
            Path<String> brandNamePath = brandPath.get("name");
            predicates.add(cb.equal(brandNamePath, brand));
        }

        Predicate predicate = null;

        if (Operation.AND == operation) {
            predicate = cb.and(predicates.toArray(new Predicate[0]));
        } else {
            predicate = cb.or(predicates.toArray(new Predicate[0]));
        }

        c.where(predicate);

        return entityManager.createQuery(c).getResultList();
    }
}
