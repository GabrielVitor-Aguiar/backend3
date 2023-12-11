package com.example.dizalaga.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dizalaga.demo.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

};