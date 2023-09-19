package com.example.rinha.controller;

import com.example.rinha.model.Pessoa;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class RinhaController {

    @PostMapping(path = "/pessoas")
    public ResponseEntity<HttpStatus> createPessoa(@Valid @RequestBody Pessoa pessoa){

        return null;
    }

    @GetMapping(path = "/pessoas/{id}")
    public ResponseEntity<HttpStatus> searchById(@PathVariable UUID id){

        return null;
    }

    @GetMapping(path = "/pessoas/term")
    public ResponseEntity<HttpStatus> searchByTerm(@RequestParam(required = true) String term){

        return null;
    }

    @GetMapping(path = "/contagem-pessoas")
    public ResponseEntity<HttpStatus> count(){

        return null;
    }
}
