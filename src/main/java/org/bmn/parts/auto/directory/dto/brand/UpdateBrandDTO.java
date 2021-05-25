package org.bmn.parts.auto.directory.dto.brand;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UpdateBrandDTO {
    @NotNull
    private final Long id;
    @NonNull
    private final String brand;
}
