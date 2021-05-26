package org.bmn.parts.auto.directory.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "brand")
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "brand_name", nullable = false)
    private String brand;

    @OneToMany(mappedBy="brand", cascade = CascadeType.ALL)
    private Set<Model> models;
}
