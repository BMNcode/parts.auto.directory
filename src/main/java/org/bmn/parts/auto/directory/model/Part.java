package org.bmn.parts.auto.directory.model;

import lombok.Data;

import javax.persistence.*;

@Data
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

	@ManyToOne
	@JoinColumn(name="model_id", nullable=false)
	private Model model;

	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	private Category category;
}
