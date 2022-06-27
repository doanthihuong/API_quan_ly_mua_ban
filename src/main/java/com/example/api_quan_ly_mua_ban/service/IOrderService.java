package com.example.api_quan_ly_mua_ban.service;

import com.example.api_quan_ly_mua_ban.model.Orders;

import java.util.Optional;

public interface IOrderService extends IGeneralService<Orders>{
    Iterable<Orders> findAll();

    Optional<Orders> findById(Long id);

    Orders save(Orders orders);

    void remove(Long id);
}
