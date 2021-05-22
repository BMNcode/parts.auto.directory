package org.bmn.parts.auto.directory.controller;

import org.bmn.parts.auto.directory.dto.*;
import org.bmn.parts.auto.directory.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PartController {

    private final PartService partService;

    @Autowired
    public PartController(PartService partService) {
        this.partService = partService;
    }

    @PostMapping("/part")
    @ResponseBody
    public Simple<PartDTO> save(@RequestBody SavePartDTO req) {
        return new Simple<>(partService.save(req));
    }

    @PutMapping("/part")
    @ResponseBody
    public Simple<PartDTO> update(@RequestBody UpdatePartDTO req) {
        return new Simple<>(partService.update(req));
    }

    @GetMapping("/part")
    @ResponseBody
    public Simple<List<PartDTO>> findByParams(@RequestBody GetPartByParamsDTO req) {
        return new Simple<>(partService.getByParams(req));
    }


}
