package org.bmn.parts.auto.directory.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class BaseResponse<T> {
    private final String message;
    private final T result;
}
