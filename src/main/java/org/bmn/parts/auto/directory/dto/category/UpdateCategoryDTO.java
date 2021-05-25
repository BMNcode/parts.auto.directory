package org.bmn.parts.auto.directory.dto.category;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UpdateCategoryDTO {
    private final Long id;
    private final String category;
}
