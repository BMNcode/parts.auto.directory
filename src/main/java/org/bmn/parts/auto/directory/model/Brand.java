package org.bmn.parts.auto.directory.model;


import lombok.Data;

import java.util.List;

@Data
public class Brand {
    private Long id;
    private String brand;
    private List<Model> models;
}
