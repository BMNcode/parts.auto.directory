package org.bmn.parts.auto.directory.dto.category;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CategoryDTO {
    private Long id;
    private final String name;

    public CategoryDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
