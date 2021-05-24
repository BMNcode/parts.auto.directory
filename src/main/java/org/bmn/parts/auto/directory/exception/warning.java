package org.bmn.parts.auto.directory.exception;

import lombok.Data;

@Data
public class warning<T> {
    private String message;
    private T body;
}
