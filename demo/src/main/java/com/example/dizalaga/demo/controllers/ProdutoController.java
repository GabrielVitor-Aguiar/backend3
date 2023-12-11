package com.example.dizalaga.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dizalaga.demo.models.Produto;
import com.example.dizalaga.demo.services.ProdutoService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService ProdutoService;

    @PostMapping
    public ResponseEntity<Produto> postMethodName(@RequestBody Produto entity) {
        
        Produto produto = ProdutoService.criarProduto(entity);
        return ResponseEntity.ok(produto);
    }
    
    @GetMapping("/{idProduto}")
    public ResponseEntity<Produto> ProdutoPorId(@PathVariable Integer idProduto){
        Produto produto = ProdutoService.getProdutoPorID(idProduto);
        if (produto != null) {
            return ResponseEntity.ok(produto);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity <Produto> produtoEdit(@PathVariable Integer id, @RequestBody Produto entity) {
        entity = ProdutoService.editarProduto(entity, id);
        return ResponseEntity.ok().body(entity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Void> produtoDelete(@PathVariable Integer id) {
        ProdutoService.desativarProduto(id);
        return ResponseEntity.noContent().build();
    }

}