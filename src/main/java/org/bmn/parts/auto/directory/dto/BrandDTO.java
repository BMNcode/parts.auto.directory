package org.bmn.parts.auto.directory.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class BrandDTO {
    private Long id;
    private final String brand;

    public BrandDTO(Long id, String brand) {
        this.id = id;
        this.brand = brand;
    }
}
