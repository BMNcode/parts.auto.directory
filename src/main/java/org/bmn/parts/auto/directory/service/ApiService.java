package org.bmn.parts.auto.directory.service;

import org.bmn.parts.auto.directory.dto.*;
import org.bmn.parts.auto.directory.model.Brand;
import org.bmn.parts.auto.directory.model.Category;
import org.bmn.parts.auto.directory.model.Model;
import org.bmn.parts.auto.directory.model.Part;
import org.bmn.parts.auto.directory.repository.BrandRepository;
import org.bmn.parts.auto.directory.repository.CategoryRepository;
import org.bmn.parts.auto.directory.repository.ModelRepository;
import org.bmn.parts.auto.directory.repository.PartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApiService {

    private final PartRepository partRepository;
    private final ModelRepository modelRepository;
    private final CategoryRepository categoryRepository;
    private final BrandRepository brandRepository;

    @Autowired
    public ApiService(PartRepository partRepository,
                      ModelRepository modelRepository,
                      CategoryRepository categoryRepository,
                      BrandRepository brandRepository) {
        this.partRepository = partRepository;
        this.modelRepository = modelRepository;
        this.categoryRepository = categoryRepository;
        this.brandRepository = brandRepository;
    }

    public PartDTO save(SavePartDTO req) {
        Part part = new Part();
        part.setPartName(req.getPartName());
        part.setArticle(req.getArticle());
        part.setModel(modelRepository.getById(req.getModelId()));
        part.setCategory(categoryRepository.getById(req.getCategoryId()));

        return part2DTO(partRepository.save(part));
    }

    public PartDTO update(UpdatePartDTO req) {
        Part part = new Part();
        part.setId(req.getId());
        part.setPartName(req.getPartName());
        part.setArticle(req.getArticle());
        part.setModel(modelRepository.getById(req.getModelId()));
        part.setCategory(categoryRepository.getById(req.getCategoryId()));

        return part2DTO(partRepository.save(part));
    }

    public List<PartDTO> getAllPart() {
        return partRepository.findAll().stream()
                .map(this::part2DTO)
                .collect(Collectors.toList());
    }

    public List<CategoryDTO> getAllCategory() {
        return categoryRepository.findAll().stream()
                .map(this::category2DTO)
                .collect(Collectors.toList());
    }

    public List<ModelDTO> getAllModel() {
        return modelRepository.findAll().stream()
                .map(this::model2DTO)
                .collect(Collectors.toList());
    }

    public List<BrandDTO> getAllBrand() {
        return brandRepository.findAll().stream()
                .map(this::brand2DTO)
                .collect(Collectors.toList());
    }

    public List<PartDTO> getByParams (String article,
                                      String partName,
                                      String category,
                                      String model,
                                      String brand,
                                      Operation operation) {
        return partRepository.findByParams(article, partName, category, model, brand, operation).stream()
                .map(this::part2DTO)
                .collect(Collectors.toList());
    }

    private PartDTO part2DTO(Part part) {
        return new PartDTO(part.getId(), part.getArticle(), part.getPartName(), model2DTO(part.getModel()), category2DTO(part.getCategory()));
    }

//    private Part dto2Part(PartDTO partDTO) {
//        return new Part(partDTO.getId(), partDTO.getArticle(), partDTO.getPartName(), model2DTO(part.getModel()), category2DTO(part.getCategory()))
//    }

    private ModelDTO model2DTO(Model model) {
        return new ModelDTO(model.getId(), model.getModel(), brand2DTO(model.getBrand()));
    }

//    private Model dto2model(ModelDTO modelDTO) {
//
//    }

    private BrandDTO brand2DTO(Brand brand) {
        return new BrandDTO(brand.getId(), brand.getBrand());
    }

//    private Brand dto2Brand(BrandDTO brandDTO) {
//
//    }

    private CategoryDTO category2DTO(Category category) {
        return new CategoryDTO(category.getId(), category.getName());
    }

//    private Category dto2Category(CategoryDTO categoryDTO) {
//
//    }

}