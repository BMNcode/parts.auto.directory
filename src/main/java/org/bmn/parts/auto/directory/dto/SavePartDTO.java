package org.bmn.parts.auto.directory.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class SavePartDTO {

    private final String article;
    private final String partName;
    private final Long categoryId;
    private final Long modelId;

}
