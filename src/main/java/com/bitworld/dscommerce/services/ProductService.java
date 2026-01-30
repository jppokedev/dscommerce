package com.bitworld.dscommerce.services;

import com.bitworld.dscommerce.dto.CategoryDTO;
import com.bitworld.dscommerce.dto.ProductDTO;
import com.bitworld.dscommerce.dto.ProductMinDTO;
import com.bitworld.dscommerce.entities.Category;
import com.bitworld.dscommerce.entities.Product;
import com.bitworld.dscommerce.repositories.ProductRepository;
import com.bitworld.dscommerce.services.exceptions.DatabaseException;
import com.bitworld.dscommerce.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true) // essa anotação tem que ser do spring, nao pode ser do jakarta, esse readOnly fala que esse metodo é so pra leitura
    public ProductDTO findById(Long id){
        Product product = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado!")); //vai la no repo pegar o produto pelo id que eu passeo no metodo converte pra produto
        return new ProductDTO(product);// pega o produto convertido e devolve como um productDto
    }

    @Transactional(readOnly = true)
    public Page<ProductMinDTO> findAll(String name, Pageable pageable){ // esse Page é um tipo especial de coleção do spring, como se fosse um List, so que pra paginação
        Page<Product> result = repository.searchByName(name, pageable);
        return result.map(x -> new ProductMinDTO(x)); // aqui vai .map direito pq o tipo Page ja é um stream
    }
    @Transactional
    public ProductDTO insert(ProductDTO dto){
        Product entity = new Product();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new ProductDTO(entity);
    }

    @Transactional
    public ProductDTO update(Long id, ProductDTO dto){
        try{
            Product entity = repository.getReferenceById(id); // serve pra instanciar um produto com a referencia passada do id, ele nao vai no banco de dados, mas é um obj monitorado pela jpa
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new ProductDTO(entity);
        }
        catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Recurso não encontrado!");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id){
        if(!repository.existsById(id)){
            throw new ResourceNotFoundException("Recurso não encontrado!");
        }
        try{
            repository.deleteById(id);
        }
        catch (DataIntegrityViolationException e){
            throw new DatabaseException("Falha de integridade referencial!");
        }
    }

    private void copyDtoToEntity(ProductDTO dto, Product entity){
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setImgUrl(dto.getImgUrl());

        entity.getCategories().clear();
        for (CategoryDTO catDto : dto.getCategories()){
            Category cat = new Category();
            cat.setId(catDto.getId());
            entity.getCategories().add(cat);
        }
    }
}
