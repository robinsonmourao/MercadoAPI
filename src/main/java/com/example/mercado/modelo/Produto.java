package com.example.mercado.modelo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String descricao;
    @Column
    private String codigo;
    @Column
    private double preco;
    @Column
    private String marca;

    public Produto(){
        this.descricao = "É a descrição do produto";
        this.preco = 0.00;
        this.marca = "É a marca do produto";
    }
    public Produto(String descricao, String codigo, double preco, String marca){
        this.descricao = descricao;
        this.preco = preco;
        this.marca = marca;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
