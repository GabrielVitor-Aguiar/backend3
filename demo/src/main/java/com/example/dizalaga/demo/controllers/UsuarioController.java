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

import com.example.dizalaga.demo.models.Usuario;
import com.example.dizalaga.demo.services.UsuarioService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping (value = "/create")
    public ResponseEntity<Usuario> postMethodName(@RequestBody Usuario entity) {
        
        Usuario user = usuarioService.criarUsuario(entity);
        return ResponseEntity.ok(user);
    }
    
    @GetMapping("/{idUsuario}")
    public ResponseEntity<Usuario> usuarioPorId(@PathVariable Integer idUsuario){
        Usuario user = usuarioService.getUsuarioPorID(idUsuario);
        if (user != null) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity <Usuario> userEdit(@PathVariable Integer id, @RequestBody Usuario entity) {
        entity = usuarioService.editarUsuario(entity, id);
        return ResponseEntity.ok().body(new Usuario(entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Void> userDelete(@PathVariable Integer id) {
        usuarioService.desativarUsuario(id);
        return ResponseEntity.noContent().build();
    }

}