package org.bmn.parts.auto.directory.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class EntityExists extends RuntimeException{
    public EntityExists(String entityName) {
        super(entityName +  " already exists");
    }
}
