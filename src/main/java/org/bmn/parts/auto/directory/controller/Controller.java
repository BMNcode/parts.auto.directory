package org.bmn.parts.auto.directory.controller;

import org.bmn.parts.auto.directory.dto.*;
import org.bmn.parts.auto.directory.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("part")
public class Controller {

    private final ApiService apiService;

    @Autowired
    public Controller(ApiService apiService) {
        this.apiService = apiService;
    }

    @PostMapping
    @ResponseBody
    public BaseResponse<PartDTO> save(@RequestBody SavePartDTO req) {
        return new BaseResponse<>(apiService.save(req));
    }

    @PutMapping
    @ResponseBody
    public BaseResponse<PartDTO> update(@RequestBody UpdatePartDTO req) {
        return new BaseResponse<>(apiService.update(req));
    }

    @GetMapping("/all")
    public BaseResponse<List<PartDTO>> getAllPart() {
        return new BaseResponse<>(apiService.getAllPart());
    }

    @GetMapping("/category/all")
    public BaseResponse<List<CategoryDTO>> getAllCategory() {
        return new BaseResponse<>(apiService.getAllCategory());
    }

    @GetMapping("/model/all")
    public BaseResponse<List<ModelDTO>> getAllModel() {
        return new BaseResponse<>(apiService.getAllModel());
    }

    @GetMapping
    @ResponseBody
    public BaseResponse<List<PartDTO>> findByParams(@RequestParam(required = false) String article,
                                                    @RequestParam(required = false) String partName,
                                                    @RequestParam(required = false) String category,
                                                    @RequestParam(required = false) String model,
                                                    @RequestParam(required = false) String brand,
                                                    @RequestParam(required = false) Operation operation) {
        return new BaseResponse<>(apiService.getByParams(article, partName, category, model, brand, operation));
    }


}
