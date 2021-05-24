package org.bmn.parts.auto.directory.dto;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class DeleteBrandDTO {

    private final Long id;
    private final String brand;

}
