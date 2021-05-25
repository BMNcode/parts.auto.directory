package org.bmn.parts.auto.directory.controller;

import org.bmn.parts.auto.directory.dto.*;
import org.bmn.parts.auto.directory.dto.brand.BrandDTO;
import org.bmn.parts.auto.directory.dto.brand.UpdateBrandDTO;
import org.bmn.parts.auto.directory.dto.brand.SaveBrandDTO;
import org.bmn.parts.auto.directory.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {

    private final BrandService brandService;

    @Autowired
    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @PostMapping
    public BaseResponse<BrandDTO> save(@RequestBody SaveBrandDTO req) {
        return brandService.existsBrand(req) ?
                new BaseResponse<>("the brand already exists ", brandService.findBrand(req)) :
                new BaseResponse<>(req.getBrand() + " successfully added ", brandService.save(req));
    }

    @PutMapping
    public BaseResponse<BrandDTO> update(@RequestBody UpdateBrandDTO req) {
        return new BaseResponse<>("successfully updated ", brandService.update(req));
    }

    @GetMapping("/all")
    public BaseResponse<List<BrandDTO>> getAllBrand() {
        return new BaseResponse<>("successfully find all brand ", brandService.getAllBrand());
    }
}
