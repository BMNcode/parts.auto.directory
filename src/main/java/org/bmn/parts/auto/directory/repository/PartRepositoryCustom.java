package org.bmn.parts.auto.directory.repository;

import org.bmn.parts.auto.directory.dto.Operation;
import org.bmn.parts.auto.directory.model.Part;

import java.util.List;
import java.util.Set;

public interface PartRepositoryCustom {
    List<Part> findByParams(String article,
                                String partName,
                                String category,
                                String model,
                                String brand,
                                Operation operation);
}
