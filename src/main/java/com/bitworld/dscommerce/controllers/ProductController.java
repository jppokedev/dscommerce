package com.bitworld.dscommerce.controllers;

import com.bitworld.dscommerce.entities.Product;
import com.bitworld.dscommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController// informa pro spring que esse componete e um controlador rest
@RequestMapping(value = "/products")// nome da requisição http
public class ProductController {

    @Autowired
    private ProductRepository repository;// aqui eu estou fazendo a associação do controle com o componete que faz as consultar no banco que no caso e o repo

    @GetMapping// informa qual o metodo rest vai ser usado e faz o mapeamento ou seja quando eu chamar o /products ele vai vir aqui buscar esse metodo
    public String teste(){
        Optional<Product> result = repository.findById(1L);// vai la no banco e pega o produto com id1
        Product product = result.get();//transforma o result em produto
        return product.getName();// pegar o nome do produto
    }

}
