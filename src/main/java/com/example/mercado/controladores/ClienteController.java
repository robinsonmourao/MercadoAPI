package com.example.mercado.controladores;

import com.example.mercado.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/v1/api")
public class ClienteController {

    @Autowired
    ClienteService clienteService;
}
