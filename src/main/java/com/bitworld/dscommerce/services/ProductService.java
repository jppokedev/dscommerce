package com.bitworld.dscommerce.services;

import com.bitworld.dscommerce.dto.ProductDTO;
import com.bitworld.dscommerce.entities.Product;
import com.bitworld.dscommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true) // essa anotação tem que ser do spring, nao pode ser do jakarta, esse readOnly fala que esse metodo é so pra leitura
    public ProductDTO findById(Long id){
        Product product = repository.findById(id).get(); //vai la no repo pegar o produto pelo id que eu passeo no metodo converte pra produto
        return new ProductDTO(product);// pega o produto convertido e devolve como um productDto
    }

    @Transactional(readOnly = true)
    public Page<ProductDTO> findAll(Pageable pageable){ // esse Page é um tipo especial de coleção do spring, como se fosse um List, so que pra paginação
        Page<Product> result = repository.findAll(pageable);
        return result.map(x -> new ProductDTO(x)); // aqui vai .map direito pq o tipo Page ja é um stream
    }

    public ProductDTO insert(ProductDTO dto){
        Product entity = new Product();
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setImgUrl(dto.getImgUrl());

        entity = repository.save(entity);

        return new ProductDTO(entity);
    }
}
