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

    @PostMapping("/clients")
    public ResponseEntity<Object> create(@RequestBody Cliente cliente) {
        try{
            return new ResponseEntity<Object>(clienteService.criarCliente(cliente.getNome(), cliente.getCpf()), HttpStatus.CREATED);
        }
        catch (IllegalArgumentException exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }
    @GetMapping("/clients/{cpf}")
    public ResponseEntity<Object> read(@PathVariable String cpf) {
        try{
            return new ResponseEntity<Object>(clienteService.buscarCliente(cpf), HttpStatus.OK);
        }
        catch (IllegalArgumentException exception){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
    }

    @PutMapping("/clients/{cpf}")
    public ResponseEntity<Object> update(@PathVariable String cpf, @RequestBody Cliente cliente) {
        try{
            return new ResponseEntity<Object>(clienteService.atualizarCliente(cpf, cliente.getNome(), cliente.getCpf()), HttpStatus.OK);
        }
        catch (IllegalArgumentException exception){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
        catch (RuntimeException exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }

    @DeleteMapping("/clients/{cpf}")
    public ResponseEntity<Object> delete(@PathVariable String cpf) {
        try{
            return new ResponseEntity<Object>(clienteService.deletarCliente(cpf), HttpStatus.OK);
        }
        catch (IllegalArgumentException exception){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
    }
}
