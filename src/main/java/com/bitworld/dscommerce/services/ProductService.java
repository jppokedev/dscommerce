package com.bitworld.dscommerce.services;

import com.bitworld.dscommerce.dto.ProductDTO;
import com.bitworld.dscommerce.entities.Product;
import com.bitworld.dscommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true) // essa anotação tem que ser do spring, nao pode ser do jakarta, esse readOnly fala que esse metodo é so pra leitura
    public ProductDTO findById(Long id){
        Product product = repository.findById(id).get(); //vai la no repo pegar o produto pelo id que eu passeo no metodo converte pra produto
        return new ProductDTO(product);// pega o produto convertido e devolve como um productDto
    }
}
