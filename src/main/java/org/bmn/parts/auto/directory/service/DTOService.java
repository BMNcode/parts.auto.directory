package org.bmn.parts.auto.directory.service;

import org.bmn.parts.auto.directory.dto.brand.BrandDTO;
import org.bmn.parts.auto.directory.dto.category.CategoryDTO;
import org.bmn.parts.auto.directory.dto.model.ModelDTO;
import org.bmn.parts.auto.directory.dto.part.PartDTO;
import org.bmn.parts.auto.directory.model.Brand;
import org.bmn.parts.auto.directory.model.Category;
import org.bmn.parts.auto.directory.model.Model;
import org.bmn.parts.auto.directory.model.Part;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DTOService {

    public PartDTO part2DTO(Part part) {
        return new PartDTO(part.getId(),
                part.getArticle(),
                part.getPartName(),
                model2DTO(part.getModels()),
                category2DTO(part.getCategory()));
    }

    public ModelDTO model2DTO(Model model) {
        return model.getId() != null ?
                new ModelDTO(model.getId(), model.getModel(), brand2DTO(model.getBrand())) :
                new ModelDTO(model.getModel(), brand2DTO(model.getBrand()));
    }

    private List<ModelDTO> model2DTO(List<Model> models) {
        return models.stream()
                .map(m -> new ModelDTO(m.getId(), m.getModel(), brand2DTO(m.getBrand())))
                .collect(Collectors.toList());
    }

    public BrandDTO brand2DTO(Brand brand) {
        return brand.getId() != null ?
                new BrandDTO(brand.getId(), brand.getBrand()) :
                new BrandDTO(brand.getBrand());
    }

    public CategoryDTO category2DTO(Category category) {
        return category.getId() != null ?
                new CategoryDTO(category.getId(), category.getCategory()) :
                new CategoryDTO(category.getCategory());
    }

}
