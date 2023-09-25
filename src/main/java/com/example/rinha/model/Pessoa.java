package com.example.rinha.model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NotBlank
@Entity(name = "PESSOA")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @NotBlank
    private String apelido;
    @NotBlank
    private String nome;
    @NotBlank
    private String nascimento;
    @ElementCollection
    private List<String> stack = new ArrayList<>();
    // salvar como uma string por virgula
}
