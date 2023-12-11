package com.example.dizalaga.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dizalaga.demo.models.Denuncia;
import com.example.dizalaga.demo.services.DenunciaService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/denuncias")
public class DenunciaController {
    @Autowired
    private DenunciaService DenunciaService;

    @PostMapping
    public ResponseEntity<Denuncia> postMethodName(@RequestBody Denuncia entity) {
        
        Denuncia denuncia = DenunciaService.criarDenuncia(entity);
        return ResponseEntity.ok(denuncia);
    }
    
    @GetMapping("/{idDenuncia}")
    public ResponseEntity<Denuncia> DenunciaPorId(@PathVariable Integer idDenuncia){
        Denuncia denuncia = DenunciaService.getDenunciaPorID(idDenuncia);
        if (denuncia != null) {
            return ResponseEntity.ok(denuncia);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


}