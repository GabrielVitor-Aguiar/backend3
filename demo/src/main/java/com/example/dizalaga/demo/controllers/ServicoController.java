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

import com.example.dizalaga.demo.models.Servico;
import com.example.dizalaga.demo.services.ServicoService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/servicos")
public class ServicoController {
    @Autowired
    private ServicoService ServicoService;

    @PostMapping
    public ResponseEntity<Servico> postMethodName(@RequestBody Servico entity) {
        
        Servico Servico = ServicoService.criarServico(entity);
        return ResponseEntity.ok(Servico);
    }
    
    @GetMapping("/{idServico}")
    public ResponseEntity<Servico> ServicoPorId(@PathVariable Integer idServico){
        Servico Servico = ServicoService.getServicoPorID(idServico);
        if (Servico != null) {
            return ResponseEntity.ok(Servico);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity <Servico> ServicoEdit(@PathVariable Integer id, @RequestBody Servico entity) {
        entity = ServicoService.editarServico(entity, id);
        return ResponseEntity.ok().body(entity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Void> ServicoDelete(@PathVariable Integer id) {
        ServicoService.desativarServico(id);
        return ResponseEntity.noContent().build();
    }

}