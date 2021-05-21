package org.bmn.parts.auto.directory.model;

import lombok.Data;

@Data
public class Part {
    private Long id;
    private String article;
	private String partName;
	private Model model;
	private Category category;
}
