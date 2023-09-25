package com.example.rinha.repository;

import com.example.rinha.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface PessoaRepository extends JpaRepository<Pessoa, UUID> {

    @Query(value = "SELECT * FROM pessoa p WHERE p.apelido = :apelido", nativeQuery = true)
    Pessoa findByApelido(String apelido);

    @Query(value = "SELECT * from pessoa p inner join pessoa_stack s on (pessoa_id = p.id and s.stack = :term)", nativeQuery = true)
    List<Pessoa> searchPessoaByStack(String term);
}
