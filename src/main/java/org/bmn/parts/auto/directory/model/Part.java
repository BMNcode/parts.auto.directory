package org.bmn.parts.auto.directory.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "part")
public class Part {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
    private Long id;

	@Column(name = "article", nullable = false)
    private String article;

	@Column(name = "part_name", nullable = false)
	private String partName;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "part_models",
			joinColumns = @JoinColumn(name = "parts_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "models_id", referencedColumnName = "id"))
	private List<Model> models;

	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	private Category category;
}
