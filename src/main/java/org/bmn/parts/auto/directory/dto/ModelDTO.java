package org.bmn.parts.auto.directory.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ModelDTO {
    private final Long id;
    private final String model;
    private final BrandDTO brand;
}
