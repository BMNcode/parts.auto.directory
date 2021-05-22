package org.bmn.parts.auto.directory.model;


import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "brand")
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "brand_name", nullable = false)
    private String brand;

    @OneToMany(mappedBy="brand")
    private Set<Model> models;
}
