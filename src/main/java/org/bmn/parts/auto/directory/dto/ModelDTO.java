package org.bmn.parts.auto.directory.dto;

import lombok.Data;

@Data
public class ModelDTO {
    private final Long id;
    private final String model;
    private final BrandDTO brand;
}
