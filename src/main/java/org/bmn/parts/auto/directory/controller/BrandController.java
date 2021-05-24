package org.bmn.parts.auto.directory.controller;

import org.bmn.parts.auto.directory.dto.*;
import org.bmn.parts.auto.directory.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("brand")
public class BrandController {

    private final BrandService brandService;

    @Autowired
    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

//    @PostMapping
//    public BaseResponse<BrandDTO> save(@RequestBody SaveBrandDTO req) {
//        BaseResponse<BrandDTO> brandDTOBaseResponse = new BaseResponse<>(brandService.save(req));
//        brandDTOBaseResponse.setMessage(req.getBrand() + " successfully added");
//        return brandDTOBaseResponse;
//    }
//
//    @GetMapping("/all")
//    public BaseResponse<List<BrandDTO>> getAllBrand() {
//        return new BaseResponse<>(brandService.getAllBrand());
//    }
//
//
//    @DeleteMapping
//    public BaseResponse<BrandDTO> delete(@RequestBody DeleteBrandDTO req) {
//        BaseResponse<BrandDTO> brandDTOBaseResponse = new BaseResponse<>(brandService.delete(req));
//        brandDTOBaseResponse.setMessage(req.getBrand() + " successfully deleted");
//        return brandDTOBaseResponse;
//    }
}
