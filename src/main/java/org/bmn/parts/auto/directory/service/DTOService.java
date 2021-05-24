package org.bmn.parts.auto.directory.service;

import org.bmn.parts.auto.directory.dto.BrandDTO;
import org.bmn.parts.auto.directory.dto.CategoryDTO;
import org.bmn.parts.auto.directory.dto.ModelDTO;
import org.bmn.parts.auto.directory.dto.PartDTO;
import org.bmn.parts.auto.directory.model.Brand;
import org.bmn.parts.auto.directory.model.Category;
import org.bmn.parts.auto.directory.model.Model;
import org.bmn.parts.auto.directory.model.Part;
import org.springframework.stereotype.Service;

@Service
public class DTOService {


    public PartDTO part2DTO(Part part) {
        return new PartDTO(part.getId(), part.getArticle(), part.getPartName(), model2DTO(part.getModel()), category2DTO(part.getCategory()));
    }

    public ModelDTO model2DTO(Model model) {
        return new ModelDTO(model.getId(), model.getName(), brand2DTO(model.getBrand()));
    }

    public BrandDTO brand2DTO(Brand brand) {
        return brand.getId() != null ? new BrandDTO(brand.getId(), brand.getBrand()) : new BrandDTO(brand.getBrand());
    }

    public CategoryDTO category2DTO(Category category) {
        return new CategoryDTO(category.getId(), category.getName());
    }

}
