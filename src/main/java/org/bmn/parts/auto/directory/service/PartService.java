package org.bmn.parts.auto.directory.service;

import org.bmn.parts.auto.directory.dto.Operation;
import org.bmn.parts.auto.directory.dto.brand.BrandDTO;
import org.bmn.parts.auto.directory.dto.category.CategoryDTO;
import org.bmn.parts.auto.directory.dto.part.PartDTO;
import org.bmn.parts.auto.directory.dto.part.SavePartDTO;
import org.bmn.parts.auto.directory.dto.part.UpdatePartDTO;
import org.bmn.parts.auto.directory.model.Part;
import org.bmn.parts.auto.directory.repository.BrandRepository;
import org.bmn.parts.auto.directory.repository.CategoryRepository;
import org.bmn.parts.auto.directory.repository.ModelRepository;
import org.bmn.parts.auto.directory.repository.PartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PartService {

    private final PartRepository partRepository;
    private final ModelRepository modelRepository;
    private final CategoryRepository categoryRepository;
    private final BrandRepository brandRepository;
    private final DTOService dtoService;

    @Autowired
    public PartService(PartRepository partRepository,
                       ModelRepository modelRepository,
                       CategoryRepository categoryRepository,
                       BrandRepository brandRepository, DTOService dtoService) {
        this.partRepository = partRepository;
        this.modelRepository = modelRepository;
        this.categoryRepository = categoryRepository;
        this.brandRepository = brandRepository;
        this.dtoService = dtoService;
    }

    public PartDTO save(SavePartDTO req) {
        Part part = new Part();
        part.setArticle(req.getArticle());
        part.setPartName(req.getPartName());
        part.setCategory(categoryRepository.getById(req.getCategoryId()));
        part.setModels(req.getModelId().stream()
                .map(modelRepository::getById)
                .collect(Collectors.toList()));

        return dtoService.part2DTO(partRepository.save(part));
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

        return dtoService.part2DTO(partRepository.save(part));
    }

    public List<PartDTO> getAllPart() {
        return partRepository.findAll().stream()
                .map(dtoService::part2DTO)
                .collect(Collectors.toList());
    }

    public List<CategoryDTO> getAllCategory() {
        return categoryRepository.findAll().stream()
                .map(dtoService::category2DTO)
                .collect(Collectors.toList());
    }

    public List<BrandDTO> getAllBrand() {
        return brandRepository.findAll().stream()
                .map(dtoService::brand2DTO)
                .collect(Collectors.toList());
    }

    public List<PartDTO> getByParams (String article,
                                      String partName,
                                      String category,
                                      String model,
                                      String brand,
                                      Operation operation) {
        if (article == null && partName == null && category == null && model == null && brand == null) {
            return Collections.emptyList();
        }
        return partRepository.findByParams(article, partName, category, model, brand, operation).stream()
                .map(dtoService::part2DTO)
                .collect(Collectors.toList());
    }

//    private PartDTO part2DTO(Part part) {
//        return new PartDTO(part.getId(),
//                           part.getArticle(),
//                           part.getPartName(),
//                           model2DTO(part.getModels()),
//                           category2DTO(part.getCategory()));
//    }
//
//    private List<ModelDTO> model2DTO(List<Model> models) {
//        return models.stream()
//                .map(m -> new ModelDTO(m.getId(), m.getModel(), brand2DTO(m.getBrand())))
//                .collect(Collectors.toList());
//    }
//
//    private BrandDTO brand2DTO(Brand brand) {
//        return new BrandDTO(brand.getId(), brand.getBrand());
//    }
//
//    private CategoryDTO category2DTO(Category category) {
//        return new CategoryDTO(category.getId(), category.getCategory());
//    }

}
