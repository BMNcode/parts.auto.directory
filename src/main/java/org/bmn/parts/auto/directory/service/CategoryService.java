package org.bmn.parts.auto.directory.service;

import org.bmn.parts.auto.directory.dto.category.CategoryDTO;
import org.bmn.parts.auto.directory.dto.category.SaveCategoryDTO;
import org.bmn.parts.auto.directory.dto.category.UpdateCategoryDTO;
import org.bmn.parts.auto.directory.model.Category;
import org.bmn.parts.auto.directory.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final DTOService dtoService;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository, DTOService dtoService) {
        this.categoryRepository = categoryRepository;
        this.dtoService = dtoService;
    }

    public CategoryDTO save(SaveCategoryDTO req) {
        Category category = new Category();
        category.setCategory(req.getCategory());
        categoryRepository.save(category);
        return dtoService.category2DTO(category);
    }

    public CategoryDTO update(UpdateCategoryDTO req) {
        Category category = new Category();
        category.setId(req.getId());
        category.setCategory(req.getCategory());
        categoryRepository.save(category);
        return dtoService.category2DTO(category);
    }

    public List<CategoryDTO> getAllCategory() {
        return categoryRepository.findAll().stream()
                .map(dtoService::category2DTO)
                .collect(Collectors.toList());
    }

    public CategoryDTO findCategory (SaveCategoryDTO req) {
        return dtoService.category2DTO(categoryRepository.findByCategory(req.getCategory()));
    }

    public boolean existsCategory (SaveCategoryDTO req) {
        return categoryRepository.existsCategoryByCategory(req.getCategory());
    }
}
