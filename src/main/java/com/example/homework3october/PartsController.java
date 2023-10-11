package com.example.homework3october;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parts")
@Slf4j
public class PartsController {

    @Autowired
    PartsService partsService;

    @Autowired
    PartsRepository partsRepository;

    @GetMapping
    public ResponseEntity<List<Part>> getParts(){
        return ResponseEntity.ok(partsService.getParts());
    }

    @PostMapping()
    public void addName(Part part){
        partsRepository.addPart(part);
    }

    @DeleteMapping("/{name}")
    public void deletePartByName(@PathVariable Part name){
        partsRepository.deletePart(name);
    }

    @PutMapping("/{name}")
    public void putPartByName(@PathVariable String name, @RequestBody Part newName){
        partsRepository.editPart(new Part(name), newName);
    }

}
