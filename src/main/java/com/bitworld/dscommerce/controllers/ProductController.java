package com.bitworld.dscommerce.controllers;

import com.bitworld.dscommerce.dto.ProductDTO;
import com.bitworld.dscommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController// informa pro spring que esse componete e um controlador rest
@RequestMapping(value = "/products")// nome da requisição http
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping(value = "/{id}")
    // informa qual o metodo rest vai ser usado e faz o mapeamento ou seja quando eu chamar o /products ele vai vir aqui buscar esse metodo
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id) {// a @pathVariable pega o valor passado na url e passa como parametro para o metodo
        ProductDTO dto = service.findById(id);// ta pegando o dto findbyid e retornando ele pra requisição
        return ResponseEntity.ok(dto); // com o responseEntity eu customizo a resposta que vai ser uma resposta 200 por conta do .ok, onde o corpo vai ser o que esta no ()
    }

    @GetMapping
    public ResponseEntity<Page<ProductDTO>> findAll(Pageable pageable){ // o Pageable faz a paginação do findAll, tem que ser o import do springframework.data.domain.Pageable;
        Page<ProductDTO> dto = service.findAll(pageable);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<ProductDTO> insert(@RequestBody ProductDTO dto){ //ResquestBody faz com que o corpo da requisição enviada no formato json entre no parametro e vire um productDto
        dto = service.insert(dto); // nao preciso declarar o dto pq estou usando a mesma variavel que veio como parametro
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);// devo fazer isso pq é uma boa pratica para retorna o codigo correto na requisição e ter o link do recurso criado que é a uri criada a cima
    }
}