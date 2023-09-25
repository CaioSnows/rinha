package com.example.rinha.service;

import com.example.rinha.exception.NotFoundException;
import com.example.rinha.exception.UnprocessableEntityException;
import com.example.rinha.model.Pessoa;
import com.example.rinha.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class PessoaService {

    @Autowired
    PessoaRepository pessoaRepository;

    public Pessoa createPessoa(Pessoa pessoa){
        verifyApelido(pessoa.getApelido());
        verifyNascimento(pessoa.getNascimento());
        verifyNome(pessoa.getNome());
        verifyStack(pessoa.getStack());

        pessoaRepository.save(pessoa);

        return pessoa;
    }

    public Pessoa searchById(UUID id){
        return pessoaRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Pessoa não encontrada"));
    }

    public List<Pessoa> searchByTerm(String term){
        return pessoaRepository.searchPessoaByStack(term);
    }

    public int countPessoas(){
        return pessoaRepository.findAll().size();
    }

    public void verifyApelido(String apelido){
        if(pessoaRepository.findByApelido(apelido) != null){
            throw new UnprocessableEntityException("Apelido já utilizado");
        }
    }

    public void verifyNome(String nome){
        if(nome.length() > 100) {
            throw new UnprocessableEntityException("Nome excede o limite de caracteres");
        }
    }

    public void verifyNascimento(String data){
        String regex = "\\d{4}-\\d{2}-\\d{2}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(data);
        if(!matcher.matches()){
            throw new UnprocessableEntityException("Formato inválido");
        }
    }

    public void verifyStack(List<String> stack){
        for (String s : stack) {
            if (s.length() > 32){
                throw new UnprocessableEntityException("Excede o limite de caracteres por stack");
            }
        }
    }
}
