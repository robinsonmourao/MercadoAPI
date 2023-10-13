package com.example.mercado.services;

import com.example.mercado.modelo.Funcionario;
import com.example.mercado.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class FuncionarioService {

    @Autowired
    FuncionarioRepository funcionarioRepository;

    public Funcionario criarFuncionario (String nome, String cpf, String cargo) {

        Optional<Funcionario> funcionarioOptional = funcionarioRepository.findByCpf(cpf);

        if (funcionarioOptional.isPresent()){
            throw new IllegalArgumentException("Já existe um funcionario cadastrado com este número de cpf!");
        }
        Funcionario funcionario = new Funcionario(nome, cpf, cargo);
        funcionarioRepository.save(funcionario);

        return funcionario;
    }

    public Funcionario buscarFuncionario (String cpf){

        Optional<Funcionario> funcionarioOptional = funcionarioRepository.findByCpf(cpf);

        if (funcionarioOptional.isEmpty()){
            throw new IllegalArgumentException("O usuário com CPF: " + cpf + " não foi encontrado!");
        }
        Funcionario funcionario = funcionarioOptional.get();

        return funcionario;
    }

    public Funcionario atualizarFuncionario (String cpf, String novoNome, String novoCpf, String novoCargo) {

        Optional<Funcionario> funcionarioOptional = funcionarioRepository.findByCpf(cpf);

        if (funcionarioOptional.isEmpty()){
            throw new IllegalArgumentException("O funcionario com CPF: " + cpf + " não foi encontrado!");
        }
        Funcionario funcionarioAnterior = funcionarioOptional.get();
        Funcionario novoFuncionario = new Funcionario(novoNome, novoCpf, novoCargo);

        if (funcionarioAnterior.getCpf().equals(novoFuncionario.getCpf())) {
            throw new RuntimeException("O cpf do funcionario novo: " + novoFuncionario.getCpf()
                    + " é o mesmo cpf do funcionario atual: " + funcionarioAnterior.getCpf());
        }
        funcionarioRepository.delete(funcionarioAnterior);
        funcionarioRepository.save(novoFuncionario);

        return novoFuncionario;
    }

    public Funcionario deletarFuncionario (String cpf) {

        Optional<Funcionario> funcionarioOptional = funcionarioRepository.findByCpf(cpf);

        if (funcionarioOptional.isEmpty()){
            throw new IllegalArgumentException("O funcionario com CPF: " + cpf + " não foi encontrado!");
        }
        Funcionario funcionario = funcionarioOptional.get();
        funcionarioRepository.delete(funcionario);

        return funcionario;
    }
}
