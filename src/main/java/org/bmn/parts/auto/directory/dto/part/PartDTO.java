package org.bmn.parts.auto.directory.dto.part;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bmn.parts.auto.directory.dto.category.CategoryDTO;
import org.bmn.parts.auto.directory.dto.model.ModelDTO;

import java.util.List;


@Getter
@RequiredArgsConstructor
public class PartDTO {
    private final Long id;
    private final String article;
    private final String partName;
    private final List<ModelDTO> model;
    private final CategoryDTO category;
}
