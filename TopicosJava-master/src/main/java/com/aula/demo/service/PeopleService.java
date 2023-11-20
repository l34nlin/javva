package com.aula.demo.service;

import com.aula.demo.Modelo.People;
import com.aula.demo.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeopleService {

    @Autowired
    private PeopleRepository repository;

    public People addPeople(People people){
        return repository.save(people);
    }
    public List<People> listAll(){
        return repository.findAll();
    }
    public Optional<People> findById(Long id){
        return repository.findById(id);
    }

    public void delPeople(Optional<People> people){
        repository.delete(people.get());
    }

}
