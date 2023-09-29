package com.example.mercado.services;

import com.example.mercado.modelo.Cliente;
import com.example.mercado.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public Cliente criarCliente (String nome, String cpf) {

        Optional<Cliente> clienteOptional = clienteRepository.findByCpf(cpf);

        if (clienteOptional.isPresent()){
            throw new IllegalArgumentException("Já existe um cliente cadastrado com este número de cpf!");
        }
        Cliente cliente = new Cliente(nome, cpf);
        clienteRepository.save(cliente);

        return cliente;
    }

    public Cliente buscarCliente (String cpf){

        Optional<Cliente> clienteOptional = clienteRepository.findByCpf(cpf);

        if (clienteOptional.isEmpty()){
			throw new IllegalArgumentException("O usuário com CPF: " + cpf + " não foi encontrado!");
		}
        Cliente cliente = clienteOptional.get();

        return cliente;
    }

    public Cliente atualizarCliente (String cpf, String novoNome, String novoCpf) {

        Optional<Cliente> clienteOptional = clienteRepository.findByCpf(cpf);

        if (clienteOptional.isEmpty()){
            throw new IllegalArgumentException("O usuário com CPF: " + cpf + " não foi encontrado!");
        }
        Cliente clienteAnterior = clienteOptional.get();
        Cliente novoCliente = new Cliente(novoNome, novoCpf);

        if (clienteAnterior.getCpf().equals(novoCliente.getCpf())) {
            throw new RuntimeException("O cpf do cliente novo: " + novoCliente.getCpf()
                    + " é o mesmo cpf do cliente atual: " + clienteAnterior.getCpf());
        }
        clienteRepository.delete(clienteAnterior);
        clienteRepository.save(novoCliente);

        return novoCliente;
    }

    public Cliente deletarCliente (String cpf) {

        Optional<Cliente> clienteOptional = clienteRepository.findByCpf(cpf);

        if (clienteOptional.isEmpty()){
            throw new IllegalArgumentException("O usuário com CPF: " + cpf + " não foi encontrado!");
        }
        Cliente cliente = clienteOptional.get();
        clienteRepository.delete(cliente);

        return cliente;
    }
}