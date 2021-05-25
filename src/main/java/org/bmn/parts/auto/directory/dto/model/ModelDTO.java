package org.bmn.parts.auto.directory.dto.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bmn.parts.auto.directory.dto.brand.BrandDTO;

@Getter
@RequiredArgsConstructor
public class ModelDTO {
    private Long id;
    private final String model;
    private final BrandDTO brand;

    public ModelDTO(Long id, String model, BrandDTO brand) {
        this.id = id;
        this.model = model;
        this.brand = brand;
    }
}
