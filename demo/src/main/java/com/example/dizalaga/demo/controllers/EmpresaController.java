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

import com.example.dizalaga.demo.models.Empresa;
import com.example.dizalaga.demo.services.EmpresaService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/empresas")
public class EmpresaController {
    @Autowired
    private EmpresaService EmpresaService;

    @PostMapping
    public ResponseEntity<Empresa> postMethodName(@RequestBody Empresa entity) {
        
        Empresa user = EmpresaService.criarEmpresa(entity);
        return ResponseEntity.ok(user);
    }
    
    @GetMapping("/{idEmpresa}")
    public ResponseEntity<Empresa> EmpresaPorId(@PathVariable Integer idEmpresa){
        Empresa user = EmpresaService.getEmpresaPorID(idEmpresa);
        if (user != null) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity <Empresa> userEdit(@PathVariable Integer id, @RequestBody Empresa entity) {
        entity = EmpresaService.editarEmpresa(entity, id);
        return ResponseEntity.ok().body(new Empresa(entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Void> userDelete(@PathVariable Integer id) {
        EmpresaService.desativarEmpresa(id);
        return ResponseEntity.noContent().build();
    }

}