package com.example.dizalaga.demo.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dizalaga.demo.models.Denuncia;
import com.example.dizalaga.demo.repository.DenunciaRepository;

@Service
public class DenunciaService {
    @Autowired
    private DenunciaRepository DenunciaRepository;

    public Denuncia getDenunciaPorID(Integer id){
        return DenunciaRepository.findById(id).orElse(null);
    }

    public Denuncia criarDenuncia(Denuncia Denuncia){
        return DenunciaRepository.save(Denuncia);        
    }

}