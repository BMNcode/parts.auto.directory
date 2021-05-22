package org.bmn.parts.auto.directory.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class GetPartByParamsDTO {

    @NonNull
    private final List<String> params;
    @NonNull
    private final Operation operation;

}
