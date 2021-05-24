package org.bmn.parts.auto.directory.service;

import org.bmn.parts.auto.directory.dto.BrandDTO;
import org.bmn.parts.auto.directory.dto.DeleteBrandDTO;
import org.bmn.parts.auto.directory.dto.SaveBrandDTO;
import org.bmn.parts.auto.directory.model.Brand;
import org.bmn.parts.auto.directory.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
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

//    public BrandDTO save(SaveBrandDTO req) {
//        Brand brand = new Brand();
//        if(brandRepository.existsBrandByBrand(req.getBrand())) {
//            return dtoService.brand2DTO(brandRepository.findByBrand(req.getBrand()));
//        }
//        brand.setBrand(req.getBrand());
//        brandRepository.save(brand);
//        return dtoService.brand2DTO(brand);
//    }
//
//    public List<BrandDTO> getAllBrand() {
//        return brandRepository.findAll().stream()
//                .map(dtoService::brand2DTO)
//                .collect(Collectors.toList());
//    }
//
//    public BrandDTO delete(DeleteBrandDTO deleteBrandDTO) {
//        Optional<Brand> optionalBrand = brandRepository.findById(deleteBrandDTO.getId());
//        if (!optionalBrand.isPresent())
//            throw new EntityNotFoundException("id-" + deleteBrandDTO.getId());
//        Brand brand = new Brand(optionalBrand.get().getId(), optionalBrand.get().getBrand(), optionalBrand.get().getModels());
//        brandRepository.deleteById(deleteBrandDTO.getId());
//        return dtoService.brand2DTO(brand);
//    }
}
