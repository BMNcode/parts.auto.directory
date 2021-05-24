package org.bmn.parts.auto.directory.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Set;


@Getter
@RequiredArgsConstructor
public class PartDTO {

    private final Long id;
    private final String article;
    private final String partName;
    private final List<ModelDTO> model;
    private final CategoryDTO category;

}
