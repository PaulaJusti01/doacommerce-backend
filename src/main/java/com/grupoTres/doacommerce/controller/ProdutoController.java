package com.grupoTres.doacommerce.controller;

import com.grupoTres.doacommerce.model.Produto;
import com.grupoTres.doacommerce.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @GetMapping
    public ResponseEntity<List<Produto>> findAllProduto() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> findByIdProduto(@PathVariable Long id) {
        return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/urgente/{urgente}")
    public ResponseEntity<List<Produto>> findAllProdutoByUrgente(@PathVariable boolean urgente) {
        return ResponseEntity.ok(repository.findAllByUrgente(urgente));
    }

    @PostMapping
    public ResponseEntity<Produto> postProduto(@RequestBody Produto produto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto));
    }

    @PutMapping
    public ResponseEntity<Produto> putProduto(@RequestBody Produto produtoPut) {//não sei qual nome colocar aqui
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(produtoPut));
    }

    @DeleteMapping("/{id}")
    public void deleteProduto(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
