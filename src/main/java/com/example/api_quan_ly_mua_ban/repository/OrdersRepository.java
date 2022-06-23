package com.example.api_quan_ly_mua_ban.repository;

import com.example.api_quan_ly_mua_ban.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Orders,Long> {
    List<Orders> findAllByCustomerNameContaining(String name);

}
