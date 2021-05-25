package org.bmn.parts.auto.directory.service;

import org.bmn.parts.auto.directory.dto.brand.BrandDTO;
import org.bmn.parts.auto.directory.dto.model.ModelDTO;
import org.bmn.parts.auto.directory.dto.model.SaveModelDTO;
import org.bmn.parts.auto.directory.dto.model.UpdateModelDTO;
import org.bmn.parts.auto.directory.model.Model;
import org.bmn.parts.auto.directory.repository.BrandRepository;
import org.bmn.parts.auto.directory.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ModelService {

    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;
    private final DTOService dtoService;

    @Autowired
    public ModelService(ModelRepository modelRepository, BrandRepository brandRepository, DTOService dtoService) {
        this.modelRepository = modelRepository;
        this.brandRepository = brandRepository;
        this.dtoService = dtoService;
    }

    public ModelDTO save(SaveModelDTO req) {
        Model model = new Model();
        model.setModel(req.getModel());
        model.setBrand(brandRepository.getById(req.getBrandId()));
        modelRepository.save(model);
        return dtoService.model2DTO(model);
    }

    public ModelDTO update(UpdateModelDTO req) {
        Model model = new Model();
        model.setId(req.getId());
        model.setModel(req.getModel());
        model.setBrand(brandRepository.getById(req.getBrandId()));
        modelRepository.save(model);
        return dtoService.model2DTO(model);
    }

    public List<ModelDTO> getAllModel() {
        return modelRepository.findAll().stream()
                .map(dtoService::model2DTO)
                .collect(Collectors.toList());
    }

    public ModelDTO findModel (SaveModelDTO req) {
        return dtoService.model2DTO(modelRepository.findByModel(req.getModel()));
    }

    public boolean existsModel (SaveModelDTO req) {
        return modelRepository.existsModelByModel((req.getModel()));
    }
}
