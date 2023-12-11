package com.example.dizalaga.demo.services;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dizalaga.demo.models.Empresa;
import com.example.dizalaga.demo.repository.EmpresaRepository;

@Service
public class EmpresaService {
    @Autowired
    private EmpresaRepository EmpresaRepository;

    public Empresa getEmpresaPorID(Integer id){
        return EmpresaRepository.findById(id).orElse(null);
    }

    public Empresa criarEmpresa(Empresa Empresa){
        return EmpresaRepository.save(Empresa);
    }

public Empresa editarEmpresa(Empresa Empresa, Integer id){
        Empresa.setId(id);
        Optional<Empresa> user = EmpresaRepository.findById(id);
        Empresa newEmpresa = new Empresa();
        if (user.isPresent() || user.get().getId() != null) {
            newEmpresa.setId(user.get().getId());
            if (user.get().getNome()!= null) {
                newEmpresa.setNome(user.get().getNome());
            }
            if (user.get().getEmail()!= null) {
                newEmpresa.setEmail(user.get().getEmail());
            }
            if (user.get().getSenha()!= null) {
                newEmpresa.setSenha(user.get().getSenha());
            }
            if (user.get().getTelefone()!= null) {
                newEmpresa.setTelefone(user.get().getTelefone());
            }
            if (user.get().getCnpj()!= null) {
                newEmpresa.setCnpj(user.get().getCnpj());
            }
            if (user.get().getCep()!= null) {
                newEmpresa.setCep(user.get().getCep());
            }


            if (Empresa.getNome() != null){
                newEmpresa.setNome(Empresa.getNome());
            }
            if (Empresa.getEmail() != null){
                newEmpresa.setEmail(Empresa.getEmail());
            }
            if (Empresa.getSenha() != null){
                newEmpresa.setSenha(Empresa.getSenha());
            }
            if (Empresa.getTelefone() != null){
                newEmpresa.setTelefone(Empresa.getTelefone());
            }
            if (Empresa.getCnpj() != null){
                newEmpresa.setCnpj(Empresa.getCnpj());
            }
            if (Empresa.getCep() != null){
                newEmpresa.setCep(Empresa.getCep());
            }

        } 
        Empresa atualizado = EmpresaRepository.save(newEmpresa);
        return atualizado;
        
    }

    public void desativarEmpresa(Integer id){
        var EmpresaBusca = EmpresaRepository.findById(id);
        if (EmpresaBusca.isPresent()){
            var Empresa = EmpresaBusca.get();
            Empresa.setIsActivated(false);
            EmpresaRepository.save(Empresa);
        }
    }

}