package com.example.mercado.controladores;

import com.example.mercado.modelo.Cliente;
import com.example.mercado.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/v1/api")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @PostMapping("/clientes")
    public ResponseEntity<Object> create(@RequestBody Cliente cliente) {
        try{ // Fluxo de sucesso
            return new ResponseEntity<Object>(
                    clienteService.criarCliente(cliente.getNome(), cliente.getCpf()), HttpStatus.CREATED
            );
        }
        catch (IllegalArgumentException exception){ // Fluxo de falha
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }
    @GetMapping("/clientes/{cpf}")
    public ResponseEntity<Object> read(@PathVariable String cpf) {
        try{ // Fluxo de sucesso
            return new ResponseEntity<Object>(
                    clienteService.buscarCliente(cpf), HttpStatus.OK
            );
        } catch (IllegalArgumentException exception){ // Fluxo de falha
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
    }

    @PutMapping("/clientes/{cpf}")
    public ResponseEntity<Object> update(@PathVariable String cpf, @RequestBody Cliente novoCliente) {
        try{ // Fluxo de sucesso
            return new ResponseEntity<Object>(
                    clienteService.atualizarCliente(cpf, novoCliente.getNome(), novoCliente.getCpf()), HttpStatus.OK
            );
        } catch (IllegalArgumentException exception){ // Fluxo de falha
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        } catch (RuntimeException exception){ // Fluxo de falha 2
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }

    @DeleteMapping("/clientes/{cpf}")
    public ResponseEntity<Object> delete(@PathVariable String cpf) {
        try{ // Fluxo de sucesso
            return new ResponseEntity<Object>(
                    clienteService.deletarCliente(cpf), HttpStatus.OK
            );
        } catch (IllegalArgumentException exception){ // Fluxo de falha
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
    }
}