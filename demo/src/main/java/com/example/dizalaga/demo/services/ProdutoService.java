package com.example.dizalaga.demo.services;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dizalaga.demo.models.Produto;
import com.example.dizalaga.demo.repository.ProdutoRepository;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository ProdutoRepository;

    public Produto getProdutoPorID(Integer id){
        return ProdutoRepository.findById(id).orElse(null);
    }

    public Produto criarProduto(Produto Produto){
        return ProdutoRepository.save(Produto);
    }

public Produto editarProduto(Produto Produto, Integer id){
        Produto.setId(id);
        Optional<Produto> user = ProdutoRepository.findById(id);
        Produto newProduto = new Produto();
        if (user.isPresent() || user.get().getId() != null) {
            newProduto.setId(user.get().getId());
            if (user.get().getNome()!= null) {
                newProduto.setNome(user.get().getNome());
            }
            if (user.get().getPreco()!= null) {
                newProduto.setPreco(user.get().getPreco());
            }
            if (user.get().getTipo()!= null) {
                newProduto.setTipo(user.get().getTipo());
            }
            if (user.get().getDescricao()!= null) {
                newProduto.setDescricao(user.get().getDescricao());
            }
            if (user.get().getMidia()!= null) {
                newProduto.setMidia(user.get().getMidia());
            }


            if (Produto.getNome() != null){
                newProduto.setNome(Produto.getNome());
            }
            if (Produto.getPreco() != null){
                newProduto.setPreco(Produto.getPreco());
            }
            if (Produto.getTipo() != null){
                newProduto.setTipo(Produto.getTipo());
            }
            if (Produto.getDescricao() != null){
                newProduto.setDescricao(Produto.getDescricao());
            }
            if (Produto.getMidia() != null){
                newProduto.setMidia(Produto.getMidia());
            }

        } 
        Produto atualizado = ProdutoRepository.save(newProduto);
        return atualizado;
        
    }

    public void desativarProduto(Integer id){
        var ProdutoBusca = ProdutoRepository.findById(id);
        if (ProdutoBusca.isPresent()){
            var Produto = ProdutoBusca.get();
            Produto.setIsActivated(false);
            ProdutoRepository.save(Produto);
        }
    }

}