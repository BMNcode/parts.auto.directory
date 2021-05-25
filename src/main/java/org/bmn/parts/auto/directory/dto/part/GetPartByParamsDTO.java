package org.bmn.parts.auto.directory.dto.part;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.bmn.parts.auto.directory.dto.Operation;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class GetPartByParamsDTO {
    private final List<String> params;
    private final Operation operation;
}
