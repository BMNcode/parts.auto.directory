package org.bmn.parts.auto.directory.controller;

import org.bmn.parts.auto.directory.dto.BaseResponse;
import org.bmn.parts.auto.directory.dto.category.CategoryDTO;
import org.bmn.parts.auto.directory.dto.category.SaveCategoryDTO;
import org.bmn.parts.auto.directory.dto.category.UpdateCategoryDTO;
import org.bmn.parts.auto.directory.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public BaseResponse<CategoryDTO> save(@RequestBody SaveCategoryDTO req) {
        return new BaseResponse<>("", categoryService.save(req));
    }

    @PutMapping
    public BaseResponse<CategoryDTO> update(@RequestBody UpdateCategoryDTO req) {
        return new BaseResponse<>("", categoryService.update(req));
    }

    @GetMapping("/all")
    public BaseResponse<List<CategoryDTO>> getAllBrand() {
        return new BaseResponse<>("", categoryService.getAllCategory());
    }

}
