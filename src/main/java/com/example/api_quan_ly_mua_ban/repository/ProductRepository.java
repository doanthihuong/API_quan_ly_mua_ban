package com.example.api_quan_ly_mua_ban.repository;

import com.example.api_quan_ly_mua_ban.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository <Product,Long> {
List<Product> findAllByNameContaining(String name);


}
