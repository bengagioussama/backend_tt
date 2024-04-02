package com.corner.app.controller;

import com.corner.app.entity.Infos;
import com.corner.app.entity.Type;
import com.corner.app.repository.InfoRepository;
import com.corner.app.repository.TypeRepository;
import com.corner.app.service.add.IInfosService;
import com.corner.app.utility.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@AllArgsConstructor // Lombok annotation to generate a constructor with all arguments
public class InfoController {
    private final IInfosService infosService; // Use constructor injection
    public TypeRepository typeRepository;
    public InfoRepository infoRepository;

   // @PostMapping("addInfo")
   // public Infos addInfo(@RequestBody Infos infos,@RequestBody Type type) {

     //   System.out.println(type);
       // return infosService.addInfos(infos);
    //}
    @PostMapping("/addInfo")
    public ResponseEntity<Infos> addInfo(@RequestBody Infos info) throws ResourceNotFoundException {

        Infos savedInfo = infoRepository.save(info);
        return new ResponseEntity<>(savedInfo, HttpStatus.CREATED);
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
