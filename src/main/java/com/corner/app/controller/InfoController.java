package com.corner.app.controller;

import com.corner.app.entity.Infos;
import com.corner.app.service.add.IInfosService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@AllArgsConstructor // Lombok annotation to generate a constructor with all arguments
public class InfoController {
    private final IInfosService infosService; // Use constructor injection

    @PostMapping("addInfo")
    public Infos addInfo(@RequestBody Infos infos) {
        return infosService.addInfos(infos);
    }

    @GetMapping("getAll")
    public List<Infos> getAllInfos(){
        return infosService.getAllInfos();
    }

    @PutMapping("infos/{id}")
    public Infos updateInfo(@PathVariable Long id, @RequestBody Infos updatedInfo) {
        return infosService.updateInfo(id, updatedInfo);
    }

    @DeleteMapping("infos/{id}")
    public void deleteInfo(@PathVariable Long id) {
        infosService.deleteInfo(id);
    }

}
