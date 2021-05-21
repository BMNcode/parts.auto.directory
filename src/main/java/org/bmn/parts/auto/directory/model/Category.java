package org.bmn.parts.auto.directory.model;

import lombok.Data;

@Data
public class Category {
    private Long id;
    private String body;
	private String engine;
	private String chassis;
	private String brakeSystem;
	private String interior;
}
