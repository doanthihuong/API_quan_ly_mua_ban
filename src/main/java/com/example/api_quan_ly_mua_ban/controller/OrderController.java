package com.example.api_quan_ly_mua_ban.controller;

import com.example.api_quan_ly_mua_ban.model.Orders;
import com.example.api_quan_ly_mua_ban.service.impl.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    OrderService orderService;
    @GetMapping("")
    public ResponseEntity<Iterable<Orders>>findAllOrder() {
        List<Orders> orders = (List<Orders>) orderService.findAll();
        if (orders.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Orders> findOrderstById(@PathVariable Long id) {
        Optional<Orders> ordersOptional = orderService.findById(id);
        if (!ordersOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ordersOptional.get(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Orders> update(@RequestBody Orders orders, @PathVariable Long id) {
        Optional<Orders> ordersOptional = orderService.findById(id);
        if (!ordersOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        orders.setId(ordersOptional.get().getId());
        LocalDateTime localDateTime = LocalDateTime.now();
        orders.setCreate(localDateTime);
        orderService.save(orders);
        return new ResponseEntity<>(orders,HttpStatus.OK);
    }
//    thêm mới
    @PostMapping
    public ResponseEntity<Orders> saveOrders(@RequestBody Orders orders) {
        return new ResponseEntity<>(orderService.save(orders),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Orders> deleteOrders(@PathVariable Long id) {
        Optional<Orders> ordersOptional = orderService.findById(id);
        if (!ordersOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        orderService.remove(id);
        return new ResponseEntity<>(ordersOptional.get(), HttpStatus.NO_CONTENT);
    }
}
