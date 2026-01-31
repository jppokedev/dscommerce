package com.bitworld.dscommerce.services;

import com.bitworld.dscommerce.dto.OrderDTO;
import com.bitworld.dscommerce.dto.ProductDTO;
import com.bitworld.dscommerce.entities.Order;
import com.bitworld.dscommerce.entities.Product;
import com.bitworld.dscommerce.repositories.OrderRepository;
import com.bitworld.dscommerce.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Transactional(readOnly = true)
    public OrderDTO findById(Long id){
        Order order = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado!"));
        return new OrderDTO(order);
    }

}
