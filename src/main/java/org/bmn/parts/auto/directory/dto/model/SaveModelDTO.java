package org.bmn.parts.auto.directory.dto.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SaveModelDTO {
    private String model;
    private Long brandId;
}
