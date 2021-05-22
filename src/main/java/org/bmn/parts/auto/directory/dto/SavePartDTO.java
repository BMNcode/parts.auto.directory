package org.bmn.parts.auto.directory.dto;

import lombok.Data;

@Data
public class SavePartDTO {

    private String article;
    private String partName;
    private Long categoryId;
    private Long modelId;

}
