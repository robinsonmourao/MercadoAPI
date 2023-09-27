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

}

//@Autowired
//    ClienteService clienteService;
//
//    @PostMapping("/clients")
//    public ResponseEntity<Cliente> create(@RequestBody Cliente cliente) {
//        try{
//            return new ResponseEntity<Cliente>(clienteService.criarCliente(cliente.getNome(), cliente.getCpf()), HttpStatus.CREATED);
//        }
//        catch (IllegalArgumentException exception){
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }
//    @GetMapping("/auth/clients/{cpf}")
//    public ResponseEntity<Cliente> read(@PathVariable String cpf) {
//        try{
//            return new ResponseEntity<Cliente>(clienteService.buscarCliente(cpf), HttpStatus.OK);
//        }
//        catch (IllegalArgumentException exception){
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
