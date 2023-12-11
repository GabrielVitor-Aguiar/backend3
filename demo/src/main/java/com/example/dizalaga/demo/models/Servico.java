package com.example.dizalaga.demo.models;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String midia;

    @Column
    private String tipo;

    @Column
    private String descricao;

    @Column
    private String preco;

    @Column
    private String nome;

    @Column
    @ColumnDefault(value = "true")
    private Boolean isActivated;

    @ManyToOne
    private Usuario user;



}
