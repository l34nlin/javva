package com.aula.demo.Modelo;

import org.springframework.data.annotation.Reference;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pessoa {

    private Long id;
    private String nome;
    private String sexo;
    LocalDate dataNascimento;
    List<Endereco> listEndereco;

    public List<Endereco> getListEndereco() {
        return listEndereco;
    }

    public void setListEndereco(List<Endereco> listEndereco) {
        this.listEndereco = listEndereco;
    }

    public Pessoa(){

    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }


}
