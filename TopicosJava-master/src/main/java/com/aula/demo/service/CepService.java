package com.aula.demo.service;

import com.aula.demo.Modelo.Cep;
import com.aula.demo.dto.CepDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(url = "https://viacep.com.br/ws/87301010/json/" , name = "cep")

public interface CepService {
    @GetMapping()
    CepDto buscaCep();
}
