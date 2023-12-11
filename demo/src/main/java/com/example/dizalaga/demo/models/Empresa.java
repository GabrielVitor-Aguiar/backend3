package com.example.dizalaga.demo.models;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.beans.BeanUtils;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Empresa {
    public Empresa(Empresa save) {
        BeanUtils.copyProperties(save, this);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String nome;

    @Column
    private String email;

    @Column
    private String senha;

    @Column
    private String cnpj;

    @Column
    private String telefone;

    @Column
    private String cep;

    @Column
    @ColumnDefault(value = "true")
    private Boolean isActivated;

}
