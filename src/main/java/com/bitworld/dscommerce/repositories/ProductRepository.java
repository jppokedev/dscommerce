package com.bitworld.dscommerce.repositories;

import com.bitworld.dscommerce.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long> { //essas interfaces repository, fazem as requisições nos bancos de dado, o jpaRepo espera que eu passe
    //a classe associada que no caso é o product e passe tb o tipo do id, que no caso é o Long

    @Query("SELECT obj FROM Product obj WHERE UPPER(obj.name) LIKE UPPER(CONCAT('%', :name, '%'))")
    Page<Product> searchByName(String name, Pageable pageable);

}
