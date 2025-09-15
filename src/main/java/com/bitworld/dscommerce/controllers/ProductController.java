package com.bitworld.dscommerce.controllers;

import com.bitworld.dscommerce.dto.ProductDTO;
import com.bitworld.dscommerce.entities.Product;
import com.bitworld.dscommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController// informa pro spring que esse componete e um controlador rest
@RequestMapping(value = "/products")// nome da requisição http
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping(value = "/{id}")// informa qual o metodo rest vai ser usado e faz o mapeamento ou seja quando eu chamar o /products ele vai vir aqui buscar esse metodo
    public ProductDTO findById(@PathVariable Long id){// a @pathVariable pega o valor passado na url e passa como parametro para o metodo
        return service.findById(id);// ta pegando o dto findbyid e retornando ele pra requisição
    }

}
