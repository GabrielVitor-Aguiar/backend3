package com.example.dizalaga.demo.services;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dizalaga.demo.models.Usuario;
import com.example.dizalaga.demo.repository.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario getUsuarioPorID(Integer id){
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario criarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

public Usuario editarUsuario(Usuario usuario, Integer id){
        usuario.setId(id);
        Optional<Usuario> user = usuarioRepository.findById(id);
        Usuario newUsuario = new Usuario();
        if (user.isPresent() || user.get().getId() != null) {
            newUsuario.setId(user.get().getId());
            if (user.get().getNome()!= null) {
                newUsuario.setNome(user.get().getNome());
            }
            if (user.get().getEmail()!= null) {
                newUsuario.setEmail(user.get().getEmail());
            }
            if (user.get().getSenha()!= null) {
                newUsuario.setSenha(user.get().getSenha());
            }
            if (user.get().getTelefone()!= null) {
                newUsuario.setTelefone(user.get().getTelefone());
            }
            if (user.get().getCpf()!= null) {
                newUsuario.setCpf(user.get().getCpf());
            }
            if (user.get().getCep()!= null) {
                newUsuario.setCep(user.get().getCep());
            }


            if (usuario.getNome() != null){
                newUsuario.setNome(usuario.getNome());
            }
            if (usuario.getEmail() != null){
                newUsuario.setEmail(usuario.getEmail());
            }
            if (usuario.getSenha() != null){
                newUsuario.setSenha(usuario.getSenha());
            }
            if (usuario.getTelefone() != null){
                newUsuario.setTelefone(usuario.getTelefone());
            }
            if (usuario.getCpf() != null){
                newUsuario.setCpf(usuario.getCpf());
            }
            if (usuario.getCep() != null){
                newUsuario.setCep(usuario.getCep());
            }

        } 
        Usuario atualizado = usuarioRepository.save(newUsuario);
        return atualizado;
        
    }

    public void desativarUsuario(Integer id){
        var usuarioBusca = usuarioRepository.findById(id);
        if (usuarioBusca.isPresent()){
            var usuario = usuarioBusca.get();
            usuario.setIsActivated(false);
            usuarioRepository.save(usuario);
        }
    }

}