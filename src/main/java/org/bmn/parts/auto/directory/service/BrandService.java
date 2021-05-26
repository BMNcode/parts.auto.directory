package org.bmn.parts.auto.directory.service;

import org.bmn.parts.auto.directory.dto.brand.BrandDTO;
import org.bmn.parts.auto.directory.dto.brand.SaveBrandDTO;
import org.bmn.parts.auto.directory.dto.brand.UpdateBrandDTO;
import org.bmn.parts.auto.directory.model.Brand;
import org.bmn.parts.auto.directory.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandService {

    private final BrandRepository brandRepository;
    private final DTOService dtoService;

    @Autowired
    public BrandService(BrandRepository brandRepository, DTOService dtoService) {
        this.brandRepository = brandRepository;
        this.dtoService = dtoService;
    }

    public BrandDTO save(SaveBrandDTO req) {
        Brand brand = new Brand();
        brand.setBrand(req.getBrand());
        brandRepository.save(brand);
        return dtoService.brand2DTO(brand);
    }

    public BrandDTO update(UpdateBrandDTO req) {
        Brand brand = new Brand();
        brand.setId(req.getId());
        brand.setBrand(req.getBrand());
        brandRepository.save(brand);
        return dtoService.brand2DTO(brand);
    }

    public List<BrandDTO> getAllBrand() {
        return brandRepository.findAll().stream()
                .map(dtoService::brand2DTO)
                .collect(Collectors.toList());
    }

    public BrandDTO findBrand (SaveBrandDTO req) {
        return dtoService.brand2DTO(brandRepository.findByBrand(req.getBrand()));
    }

    public boolean existsBrand (SaveBrandDTO req) {
        return brandRepository.existsBrandByBrand(req.getBrand());
    }

}
