package com.bitworld.dscommerce.repositories;

import com.bitworld.dscommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> { //essas interfaces repository, fazem as requisições nos bancos de dado, o jpaRepo espera que eu passe
    //a classe associada que no caso é o product e passe tb o tipo do id, que no caso é o Long
}
