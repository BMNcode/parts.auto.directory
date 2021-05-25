package org.bmn.parts.auto.directory.dto.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UpdateModelDTO {
    private final Long id;
    private final String model;
    private final Long brandId;
}
