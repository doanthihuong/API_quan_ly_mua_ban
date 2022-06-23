package com.example.api_quan_ly_mua_ban.service.impl;

import com.example.api_quan_ly_mua_ban.model.Orders;
import com.example.api_quan_ly_mua_ban.repository.OrdersRepository;
import com.example.api_quan_ly_mua_ban.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class OrderService implements IOrderService {
    @Autowired
    OrdersRepository ordersRepository;
    @Override
    public Iterable<Orders> findAll() {
        return ordersRepository.findAll();
    }

    @Override
    public Optional<Orders> findById(Long id) {
        return ordersRepository.findById(id);
    }

    @Override
    public Orders save(Orders orders) {
        return ordersRepository.save(orders);
    }

    @Override
    public void remove(Long id) {
        ordersRepository.deleteById(id);

    }
}
