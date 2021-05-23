package org.bmn.parts.auto.directory.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@RequiredArgsConstructor
public class PartDTO {

    private final Long id;
    private final String article;
    private final String partName;
    private final ModelDTO model;
    private final CategoryDTO category;

}
