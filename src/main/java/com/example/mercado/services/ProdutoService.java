package com.example.mercado.services;

import com.example.mercado.modelo.Produto;
import com.example.mercado.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    public Produto criarProduto (String descricao, String codigo, double preco, String marca) {

        Optional<Produto> produtoOptional = produtoRepository.findByCodigo(codigo);

        if (produtoOptional.isPresent()){
            throw new IllegalArgumentException("Já existe um produto cadastrado com este número de codigo!");
        }
        Produto produto = new Produto(descricao, codigo, preco, marca);
        produtoRepository.save(produto);

        return produto;
    }

    public Produto buscarProduto(String codigo){

        Optional<Produto> produtoOptional = produtoRepository.findByCodigo(codigo);

        if (produtoOptional.isEmpty()){
            throw new IllegalArgumentException("O produto com CODIGO: " + codigo + " não foi encontrado!");
        }
        Produto produto = produtoOptional.get();

        return produto;
    }

    public Produto atualizarProduto(String codigo, String novaDescricao, String novoCodigo, double novoPreco, String novaMarca) {

        Optional<Produto> produtoOptional = produtoRepository.findByCodigo(codigo);

        if (produtoOptional.isEmpty()){
            throw new IllegalArgumentException("O produto com CODIGO: " + codigo + " não foi encontrado!");
        }
        Produto produtoAnterior = produtoOptional.get();
        Produto novoProduto = new Produto(novaDescricao, novoCodigo, novoPreco, novaMarca);

        if (produtoAnterior.getCodigo().equals(novoProduto.getCodigo())) {
            throw new RuntimeException("O cpf do produto novo: " + novoProduto.getCodigo()
                    + " é o mesmo cpf do produto atual: " + produtoAnterior.getCodigo());
        }
        produtoRepository.delete(produtoAnterior);
        produtoRepository.save(novoProduto);

        return novoProduto;
    }

    public Produto deletarProduto(String codigo) {

        Optional<Produto> produtoOptional = produtoRepository.findByCodigo(codigo);

        if (produtoOptional.isEmpty()){
            throw new IllegalArgumentException("O produto com CODIGO: " + codigo + " não foi encontrado!");
        }
        Produto produto = produtoOptional.get();
        produtoRepository.delete(produto);

        return produto;
    }
}
