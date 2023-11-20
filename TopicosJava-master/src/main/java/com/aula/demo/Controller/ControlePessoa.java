package com.aula.demo.Controller;

import com.aula.demo.Modelo.Endereco;
import com.aula.demo.Modelo.Pessoa;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class ControlePessoa {

    private int id = 1;
    private int idEnd = 1;
    private Pessoa p;
    private Endereco e;

    private final List<Pessoa> pessoaList = new ArrayList<>();
    private final List<Endereco> enderecoList = new ArrayList<>();

    @PostMapping()
    public Pessoa addPessoa(@RequestBody Pessoa pe){
        p = new Pessoa();
        p.setId(Long.valueOf(id++));
        p.setNome(pe.getNome());
        p.setSexo(pe.getSexo());
        p.setDataNascimento(pe.getDataNascimento());

        for(Endereco end : pe.getListEndereco()) {
            end.setId(Long.valueOf(idEnd++));
        }

        p.setListEndereco(pe.getListEndereco());

        pessoaList.add(p);

        return p;
    }


    @GetMapping()
    public List<Pessoa> listPessoa(){
        return pessoaList;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> listId(@PathVariable(value = "id")Long id){
        if(!pessoaList.isEmpty()){
            for(Pessoa p : pessoaList){
                if(p.getId() == id){
                    return ResponseEntity.status(HttpStatus.OK).body(p);
                }
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nao encontrado");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> newPessoa(@PathVariable(value = "id") Long id,@RequestBody Pessoa pe){
        if(!pessoaList.isEmpty()){
            for(Pessoa p : pessoaList){
                if(p.getId() == id){
                    p.setNome(pe.getNome());
                    p.setSexo(pe.getSexo());
                    p.setDataNascimento(pe.getDataNascimento());

                    return ResponseEntity.status(HttpStatus.OK).body(p);
                }
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delPessoa(@PathVariable(value = "id")Long id){
        if(!pessoaList.isEmpty()){
            for(Pessoa p : pessoaList){
                if(p.getId() == id){
                    pessoaList.remove(p);
                    return ResponseEntity.status(HttpStatus.OK).body(p);
                }
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado");
    }








}
