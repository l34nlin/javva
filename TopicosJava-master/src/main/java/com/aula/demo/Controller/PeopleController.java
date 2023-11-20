package com.aula.demo.Controller;

import com.aula.demo.Modelo.People;
import com.aula.demo.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/people")
public class PeopleController {

    @Autowired
    private PeopleService service;

    @PostMapping
    public ResponseEntity<Object> addPeople(@RequestBody People people){
        return ResponseEntity.status(HttpStatus.OK).body(service.addPeople(people));
    }
    @GetMapping
    public ResponseEntity<List<People>> listAll(){
        return ResponseEntity.status(HttpStatus.OK).body(service.listAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<People>> findById(@PathVariable(value = "id")Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }
    @PutMapping("/{id}")
    public  ResponseEntity<Object> putPeople(@PathVariable(value = "id")Long id,@RequestBody People people){
        Optional<People> p = service.findById(id);

        if(p.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body("People does't exist");
        }

        People people1 = p.get();

        people1.setNome(people.getNome());
        people1.setCpf(people.getCpf());
        people1.setSexo(people.getSexo());

        return ResponseEntity.status(HttpStatus.OK).body(service.addPeople(people1));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delPeople(@PathVariable(value = "id")Long id){
        Optional<People> p = service.findById(id);

        if(p.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body("People does't exist ");
        }

        service.delPeople(p);

        return ResponseEntity.status(HttpStatus.OK).body("People deleted");
    }


}
