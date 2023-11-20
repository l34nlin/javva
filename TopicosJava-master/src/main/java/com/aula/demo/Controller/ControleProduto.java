package com.aula.demo.Controller;

import com.aula.demo.Modelo.Produto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/produto")
public class ControleProduto {

    private final List<Produto> listaProduto = new ArrayList<>();

    private Produto p;
    private int id = 1;

    @PostMapping()
    public Produto addProduto(@RequestBody Produto prod){
        p = new Produto();
        p.setCodigo(Long.valueOf(id++));
        p.setDescricao(prod.getDescricao());
        p.setValor(prod.getValor());
        listaProduto.add(p);

        return p;
    }
    @GetMapping()
    public List<Produto> listaProduto(){
        return listaProduto;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> prodCodigo(@PathVariable(value = "id") Long id){
        if(!listaProduto.isEmpty()){
            for(Produto p : listaProduto) {
                if(p.getCodigo() == id) {
                    return ResponseEntity.status(HttpStatus.OK).body(p);
                }
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não localizado !");
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> altProd (@PathVariable(value = "id") Long id, @RequestBody Produto prod){
        if(!listaProduto.isEmpty()){
            for(Produto p : listaProduto) {
                if(p.getCodigo() == id) {
                    p.setDescricao(prod.getDescricao());
                    p.setValor(prod.getValor());
                    return ResponseEntity.status(HttpStatus.OK).body(p);
                }
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não localizado !");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delProd(@PathVariable(value = "id")Long id){
            if(!listaProduto.isEmpty()){
                for (Produto p : listaProduto){
                    if(p.getCodigo() == id){
                        listaProduto.remove(p);
                        return ResponseEntity.status(HttpStatus.OK).body(p);
                    }
                }
            }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não localizado !");
    }
}
