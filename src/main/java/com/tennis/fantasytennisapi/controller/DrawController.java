package com.tennis.fantasytennisapi.controller;

import com.tennis.fantasytennisapi.request.Bracket;
import com.tennis.fantasytennisapi.service.DrawService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DrawController {
    
    @Autowired
    private DrawService drawService;

    @GetMapping("/ftapi/v1/bracket/get")
    public ResponseEntity<Bracket> getBracket() {
        
        Bracket bracket = drawService.getBracket();

        return new ResponseEntity<Bracket>(bracket, HttpStatus.OK);
    }

    @PostMapping("/ftapi/v1/bracket/add")
    public ResponseEntity<String> addBracket(@RequestBody Bracket bracket) {
        
        String response = drawService.addBracket(bracket);

        return new ResponseEntity<String>(response, HttpStatus.OK);
    }

}