package com.example.dizalaga.demo.services;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dizalaga.demo.models.Servico;
import com.example.dizalaga.demo.repository.ServicoRepository;

@Service
public class ServicoService {
    @Autowired
    private ServicoRepository ServicoRepository;

    public Servico getServicoPorID(Integer id){
        return ServicoRepository.findById(id).orElse(null);
    }

    public Servico criarServico(Servico Servico){
        return ServicoRepository.save(Servico);
    }

public Servico editarServico(Servico Servico, Integer id){
        Servico.setId(id);
        Optional<Servico> user = ServicoRepository.findById(id);
        Servico newServico = new Servico();
        if (user.isPresent() || user.get().getId() != null) {
            newServico.setId(user.get().getId());
            if (user.get().getNome()!= null) {
                newServico.setNome(user.get().getNome());
            }
            if (user.get().getPreco()!= null) {
                newServico.setPreco(user.get().getPreco());
            }
            if (user.get().getTipo()!= null) {
                newServico.setTipo(user.get().getTipo());
            }
            if (user.get().getDescricao()!= null) {
                newServico.setDescricao(user.get().getDescricao());
            }
            if (user.get().getMidia()!= null) {
                newServico.setMidia(user.get().getMidia());
            }


            if (Servico.getNome() != null){
                newServico.setNome(Servico.getNome());
            }
            if (Servico.getPreco() != null){
                newServico.setPreco(Servico.getPreco());
            }
            if (Servico.getTipo() != null){
                newServico.setTipo(Servico.getTipo());
            }
            if (Servico.getDescricao() != null){
                newServico.setDescricao(Servico.getDescricao());
            }
            if (Servico.getMidia() != null){
                newServico.setMidia(Servico.getMidia());
            }

        } 
        Servico atualizado = ServicoRepository.save(newServico);
        return atualizado;
        
    }

    public void desativarServico(Integer id){
        var ServicoBusca = ServicoRepository.findById(id);
        if (ServicoBusca.isPresent()){
            var Servico = ServicoBusca.get();
            Servico.setIsActivated(false);
            ServicoRepository.save(Servico);
        }
    }

}