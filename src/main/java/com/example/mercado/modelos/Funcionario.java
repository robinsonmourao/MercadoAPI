//package com.example.mercado.modelos;
//
//import javax.persistence.*;
//import java.io.Serializable;
//
//public class Funcionario implements Serializable {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//    @Column
//    private String nome;
//    @Column
//    private String cpf;
//    @Column
//    private String cargo;
//
//    public Funcionario () {
//        this.nome = "É nome de funcionario";
//        this.cpf = "É cpf de funcionario";
//        this.cargo = "É o cargo do funcionario";
//    }
//    public Funcionario (String nome, String cpf, String cargo) {
//        this.nome = nome;
//        this.cpf = cpf;
//        this.cargo = cargo;
//    }
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getNome() {
//        return nome;
//    }
//
//    public void setNome(String nome) {
//        this.nome = nome;
//    }
//
//    public String getCpf() {
//        return cpf;
//    }
//
//    public void setCpf(String CPF) {
//        this.cpf = CPF;
//    }
//
//    public String getCargo() {
//        return cargo;
//    }
//
//    public void setCargo(String cargo) {
//        this.cargo = cargo;
//    }
//}
