package com.example.rinha.controller;

import com.example.rinha.model.Pessoa;
import com.example.rinha.repository.PessoaRepository;
import com.example.rinha.service.PessoaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/rinha")
@RequiredArgsConstructor
public class RinhaController {

    private final PessoaService pessoaService;

    @PostMapping(path = "/pessoas")
    public ResponseEntity<Pessoa> createPessoa(@Valid @RequestBody Pessoa pessoa){
        Pessoa createdPessoa = pessoaService.createPessoa(pessoa);
        return ResponseEntity.ok(createdPessoa);
    }

    @GetMapping(path = "/pessoas/{id}")
    public ResponseEntity<Pessoa> searchById(@PathVariable UUID id){
        Pessoa pessoa = pessoaService.searchById(id);
        return ResponseEntity.ok(pessoa);
    }

    @GetMapping(path = "/pessoas/stack")
    public ResponseEntity<List<Pessoa>> searchByTerm(@RequestParam(required = true) String term){
        List<Pessoa> pessoaLists = pessoaService.searchByTerm(term);
        return ResponseEntity.ok(pessoaLists);
    }

    @GetMapping(path = "/contagem-pessoas")
    public ResponseEntity<Integer> count(){
        int count = pessoaService.countPessoas();
        return ResponseEntity.ok(count);
    }
}
