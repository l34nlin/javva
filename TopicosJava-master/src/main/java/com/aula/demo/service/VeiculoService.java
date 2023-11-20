package com.aula.demo.service;

import com.aula.demo.Modelo.Veiculo;
import com.aula.demo.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {
    @Autowired
    private VeiculoRepository repository;

    public Veiculo addVeiculo(Veiculo veiculo){
        return repository.save(veiculo);
    }
    public List<Veiculo> findAll(){
        return repository.findAll();
    }
    public Optional<Veiculo> findById(Long id){
        return repository.findById(id);
    }
    public void delVeiculo(Optional<Veiculo> veiculo){
        repository.delete(veiculo.get());
    }
}
