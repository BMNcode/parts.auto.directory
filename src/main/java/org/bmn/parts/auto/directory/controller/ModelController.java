package org.bmn.parts.auto.directory.controller;

import org.bmn.parts.auto.directory.dto.BaseResponse;
import org.bmn.parts.auto.directory.dto.model.ModelDTO;
import org.bmn.parts.auto.directory.dto.model.SaveModelDTO;
import org.bmn.parts.auto.directory.dto.model.UpdateModelDTO;
import org.bmn.parts.auto.directory.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/model")
public class ModelController {

    private final ModelService modelService;

    @Autowired
    public ModelController(ModelService modelService) {
        this.modelService = modelService;
    }

    @PostMapping
    public BaseResponse<ModelDTO> save(@RequestBody SaveModelDTO req) {
        return modelService.existsModel(req) ?
                new BaseResponse<>("the model already exists ", modelService.findModel(req)) :
                new BaseResponse<>(req.getModel() + " successfully added ", modelService.save(req));
    }

    @PutMapping
    public BaseResponse<ModelDTO> update(@RequestBody UpdateModelDTO req) {
        return new BaseResponse<>("successfully updated ", modelService.update(req));
    }

    @GetMapping("/all")
    public BaseResponse<List<ModelDTO>> getAllModel() {
        return new BaseResponse<>("successfully find all model ", modelService.getAllModel());
    }
}
