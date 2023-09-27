package com.example.mercado.modelo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "cpf")
    private String cpf;

    public Cliente () {
        this.nome = "É nome de cliente";
        this.cpf = "É cpf de cliente";
    }
    public Cliente (String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String CPF) {
        this.cpf = CPF;
    }

}
