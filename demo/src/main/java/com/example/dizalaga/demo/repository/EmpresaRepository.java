package com.example.dizalaga.demo.repository;

import com.example.dizalaga.demo.models.Empresa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {

};