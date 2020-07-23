package com.tennis.fantasytennisapi.controller;

import java.util.List;

import com.tennis.fantasytennisapi.entity.SimpleEntity;
import com.tennis.fantasytennisapi.request.Simple;
import com.tennis.fantasytennisapi.service.SimpleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {
    
    @Autowired
    private SimpleService simpleService;

    @PostMapping("/simple/add")
    public ResponseEntity<Simple> addSimple(@RequestBody Simple input) {
        
        Simple result = simpleService.addSimple(input);

        return new ResponseEntity<Simple>(result, HttpStatus.OK);
    }

    @PostMapping("/simple/delete")
    public ResponseEntity<Simple> deleteSimple(@RequestBody Simple input) {

        Simple result = simpleService.deleteSimple(input);

        return new ResponseEntity<Simple>(result, HttpStatus.OK);
    }

    @GetMapping("/simple/get")
    public ResponseEntity<List<SimpleEntity>> getSimple() {

        List<SimpleEntity> result = simpleService.getSimple();

        return new ResponseEntity<List<SimpleEntity>>(result, HttpStatus.OK);
    }

}