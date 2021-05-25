package org.bmn.parts.auto.directory.service;

import org.bmn.parts.auto.directory.dto.*;
import org.bmn.parts.auto.directory.dto.brand.BrandDTO;
import org.bmn.parts.auto.directory.dto.category.CategoryDTO;
import org.bmn.parts.auto.directory.dto.model.ModelDTO;
import org.bmn.parts.auto.directory.dto.part.PartDTO;
import org.bmn.parts.auto.directory.dto.part.SavePartDTO;
import org.bmn.parts.auto.directory.dto.part.UpdatePartDTO;
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
public class PartService {

    private final PartRepository partRepository;
    private final ModelRepository modelRepository;
    private final CategoryRepository categoryRepository;
    private final BrandRepository brandRepository;

    @Autowired
    public PartService(PartRepository partRepository,
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
        part.setArticle(req.getArticle());
        part.setPartName(req.getPartName());
        part.setCategory(categoryRepository.getById(req.getCategoryId()));
        part.setModels(req.getModelId().stream()
                .map(modelRepository::getById)
                .collect(Collectors.toList()));

        return part2DTO(partRepository.save(part));
    }

    public PartDTO update(UpdatePartDTO req) {
        Part part = new Part();
        part.setId(req.getId());
        part.setPartName(req.getPartName());
        part.setArticle(req.getArticle());
        part.setModels(req.getModelId().stream()
                .map(modelRepository::getById)
                .collect(Collectors.toList()));
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

//    public List<ModelDTO> getAllModel() {
//        return modelRepository.findAll().stream()
//                .map(this::model2DTO)
//                .collect(Collectors.toList());
//    }

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
        return new PartDTO(part.getId(),
                           part.getArticle(),
                           part.getPartName(),
                           model2DTO(part.getModels()),
                           category2DTO(part.getCategory()));
    }

//    private Part dto2Part(PartDTO partDTO) {
//        return new Part(partDTO.getId(), partDTO.getArticle(), partDTO.getPartName(), model2DTO(part.getModel()), category2DTO(part.getCategory()))
//    }

    private List<ModelDTO> model2DTO(List<Model> models) {
        return models.stream()
                .map(m -> new ModelDTO(m.getId(), m.getModel(), brand2DTO(m.getBrand())))
                .collect(Collectors.toList());
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
        return new CategoryDTO(category.getId(), category.getCategory());
    }

//    private Category dto2Category(CategoryDTO categoryDTO) {
//
//    }

}
