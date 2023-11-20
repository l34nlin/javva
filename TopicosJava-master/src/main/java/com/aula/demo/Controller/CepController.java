package com.aula.demo.Controller;

import com.aula.demo.dto.CepDto;
import com.aula.demo.facede.CepFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cep")
public class CepController {

    @Autowired
    private CepFacade cepFacade;

    @GetMapping
    public CepDto buscaCep(){
        return cepFacade.buscaCep();
    }

}
