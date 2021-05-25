package org.bmn.parts.auto.directory.controller;

import org.bmn.parts.auto.directory.dto.*;
import org.bmn.parts.auto.directory.dto.part.PartDTO;
import org.bmn.parts.auto.directory.dto.part.SavePartDTO;
import org.bmn.parts.auto.directory.dto.part.UpdatePartDTO;
import org.bmn.parts.auto.directory.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("part")
public class PartController {

    private final PartService partService;

    @Autowired
    public PartController(PartService partService) {
        this.partService = partService;
    }

    @PostMapping
    public BaseResponse<PartDTO> save(@RequestBody SavePartDTO req) {
        return new BaseResponse<>(req.getPartName() + " successfully added", partService.save(req));
    }

    @PutMapping
    public BaseResponse<PartDTO> update(@RequestBody UpdatePartDTO req) {
        return new BaseResponse<>(req.getPartName() + " successfully updated", partService.update(req));
    }

    @GetMapping
    public BaseResponse<List<PartDTO>> findByParams(@RequestParam(required = false) String article,
                                                    @RequestParam(required = false) String partName,
                                                    @RequestParam(required = false) String category,
                                                    @RequestParam(required = false) String model,
                                                    @RequestParam(required = false) String brand,
                                                    @RequestParam(required = false) Operation operation) {
        return new BaseResponse<>("successfully find", partService.getByParams(article, partName, category, model, brand, operation));
    }

    @GetMapping("/all")
    public BaseResponse<List<PartDTO>> getAllPart() {
        return new BaseResponse<>("successfully find all part", partService.getAllPart());
    }

//    @GetMapping("/category/all")
//    public BaseResponse<List<CategoryDTO>> getAllCategory() {
//        return new BaseResponse<>(partService.getAllCategory());
//    }

//    @GetMapping("/model/all")
//    public BaseResponse<List<ModelDTO>> getAllModel() {
//        return new BaseResponse<>(apiService.getAllModel());
//    }


}
