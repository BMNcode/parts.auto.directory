package org.bmn.parts.auto.directory.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Simple<T> {
    private final T result;
}
