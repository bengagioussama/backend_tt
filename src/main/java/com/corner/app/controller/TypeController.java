// TypeController.java
package com.corner.app.controller;

import com.corner.app.entity.Type;
import com.corner.app.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class TypeController {

    private final TypeService typeService;

    @Autowired
    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }

    @GetMapping("/types")
    public List<Type> getAllTypes() {
        return typeService.getAllTypes();
    }

    @GetMapping("/{id}")
    public Type getTypeById(@PathVariable Long id) {
        return typeService.getTypeById(id);
    }

    @PostMapping("/types/createType")
    public Type createType(@RequestBody Type type) {
        return typeService.createType(type);
    }

    @PutMapping("/{id}")
    public Type updateType(@PathVariable Long id, @RequestBody Type type) {
        return typeService.updateType(id, type);
    }

    @DeleteMapping("/{id}")
    public void deleteType(@PathVariable Long id) {
        typeService.deleteType(id);
    }
}

