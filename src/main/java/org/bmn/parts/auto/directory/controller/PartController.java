package org.bmn.parts.auto.directory.controller;

import org.bmn.parts.auto.directory.dto.*;
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
    @ResponseBody
    public BaseResponse<PartDTO> save(@RequestBody SavePartDTO req) {
        BaseResponse<PartDTO> partDTOBaseResponse = new BaseResponse<>(partService.save(req));
        partDTOBaseResponse.setMessage(req.getPartName() + " successfully added");
        return partDTOBaseResponse;
    }

    @PutMapping
    @ResponseBody
    public BaseResponse<PartDTO> update(@RequestBody UpdatePartDTO req) {
        BaseResponse<PartDTO> partDTOBaseResponse = new BaseResponse<>(partService.update(req));
        partDTOBaseResponse.setMessage(req.getPartName() + " successfully updated");
        return new BaseResponse<>(partService.update(req));
    }

    @GetMapping("/all")
    public BaseResponse<List<PartDTO>> getAllPart() {
        return new BaseResponse<>(partService.getAllPart());
    }

    @GetMapping("/category/all")
    public BaseResponse<List<CategoryDTO>> getAllCategory() {
        return new BaseResponse<>(partService.getAllCategory());
    }

//    @GetMapping("/model/all")
//    public BaseResponse<List<ModelDTO>> getAllModel() {
//        return new BaseResponse<>(apiService.getAllModel());
//    }

    @GetMapping
    @ResponseBody
    public BaseResponse<List<PartDTO>> findByParams(@RequestParam(required = false) String article,
                                                    @RequestParam(required = false) String partName,
                                                    @RequestParam(required = false) String category,
                                                    @RequestParam(required = false) String model,
                                                    @RequestParam(required = false) String brand,
                                                    @RequestParam(required = false) Operation operation) {
        return new BaseResponse<>(partService.getByParams(article, partName, category, model, brand, operation));
    }


}
