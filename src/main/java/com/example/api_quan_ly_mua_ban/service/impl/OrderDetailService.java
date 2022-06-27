package com.example.api_quan_ly_mua_ban.service.impl;



import com.example.api_quan_ly_mua_ban.model.OrderDetail;
import com.example.api_quan_ly_mua_ban.repository.OrderDetailRepository;
import com.example.api_quan_ly_mua_ban.service.IOrderDetailService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderDetailService implements IOrderDetailService{

@Autowired
    OrderDetailRepository orderDetailRepository;
    @Override
    public Iterable<OrderDetail> findAll() {
        return orderDetailRepository.findAll();
    }

    @Override
    public Optional<OrderDetail> findById(Long id) {
        return orderDetailRepository.findById(id);
    }

    @Override
    public OrderDetail save(OrderDetail orders) {
        return orderDetailRepository.save(orders);
    }

    @Override
    public void remove(Long id) {
        orderDetailRepository.deleteById(id);

    }
}
