package com.aula.demo.Controller;

import com.aula.demo.Modelo.Veiculo;
import com.aula.demo.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {
    @Autowired
    private VeiculoService service;
    @PostMapping
    public ResponseEntity<Object> addVeiculo(@RequestBody Veiculo veiculo){
        return ResponseEntity.status(HttpStatus.OK).body(service.addVeiculo(veiculo));
    }
    @GetMapping
    public ResponseEntity<List<Veiculo>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Veiculo>> findById(@PathVariable(value = "id")Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> putVeiculo(@PathVariable(value = "id")Long id,@RequestBody Veiculo veiculo){

        Optional<Veiculo> v = service.findById(id);

        if(v.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body("Não localizado");
        }

        Veiculo veiculo1 = v.get();

        veiculo1.setModelo(veiculo.getModelo());
        veiculo1.setMarca(veiculo.getMarca());
        veiculo1.setCor(veiculo.getCor());

        return ResponseEntity.status(HttpStatus.OK).body(service.addVeiculo(veiculo1));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delVeiculo(@PathVariable(value = "id")Long id){

        Optional<Veiculo> v = service.findById(id);

        if(v.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body("Não localizado");
        }

        service.delVeiculo(v);

        return ResponseEntity.status(HttpStatus.OK).body("Veiculo deletado");
    }


}
