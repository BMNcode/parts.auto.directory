package org.bmn.parts.auto.directory.dto;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UpdatePartDTO {

    private Long id;
    private String article;
    private String partName;
    private Long categoryId;
    private Long modelId;

}
