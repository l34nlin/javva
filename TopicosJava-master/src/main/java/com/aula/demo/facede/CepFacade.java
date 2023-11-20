package com.aula.demo.facede;

import com.aula.demo.Modelo.Cep;
import com.aula.demo.dto.CepDto;
import com.aula.demo.service.CepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CepFacade {
    @Autowired
    private CepService service;

    public CepDto buscaCep(){
        return service.buscaCep();
    }
}
