package com.example.api_quan_ly_mua_ban.controller;
import com.example.api_quan_ly_mua_ban.model.OrderDetail;
import com.example.api_quan_ly_mua_ban.model.Orders;
import com.example.api_quan_ly_mua_ban.model.Product;
import com.example.api_quan_ly_mua_ban.service.impl.OrderDetailService;
import com.example.api_quan_ly_mua_ban.service.impl.OrderService;
import com.example.api_quan_ly_mua_ban.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.Order;
import java.util.Optional;


@Controller
@RequestMapping("/orders_detail")
public class OrderDetailController {
    @Autowired
    OrderService orderService;
    @Autowired
    OrderDetailService orderDetailService;
    @Autowired
    ProductService productService;


    @GetMapping("")
    public ResponseEntity findAll() {
        return new ResponseEntity(orderDetailService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody OrderDetail orderDetail) {
        Product product = productService.findById(orderDetail.getProduct().getId()).get();
        Orders orders = orderService.findById(orderDetail.getOrders().getId()).get();
        product.setQuantity( (product.getQuantity() - orderDetail.getQuantity()));
        productService.save(product);
        orders.setPrice(orders.getPrice() + product.getQuantity() * product.getPrice());
        orderService.save(orders);
        return new ResponseEntity(orderDetailService.save(orderDetail), HttpStatus.CREATED);
    }

//    chưa xong phần này

//
//    @DeleteMapping("/details/{idd}")
//    public ResponseEntity<OrderDetail> delete(@PathVariable Long idd) {
//        OrderDetail orderDetail = orderDetailService.findById(idd).get();
//        orderDetailService.remove(idd);
//        Product product = orderDetail.getProduct();
//        product.setQuantity(product.getQuantity() + orderDetail.getQuantity());
//        productService.save(product);
//        Orders orders = orderDetail.getOrders();
//        long total = orders.getAmount() - product.getPrice() * orderDetail.getQuantity();
//        orders.setAmount(total);
//        orderService.save(orderr);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }



    @PutMapping("/{id}")
    public ResponseEntity<Orders> update(@PathVariable Long id, @RequestBody Orders orders) {
        Optional<Orders> orders1 = orderService.findById(id);
        if(!orders1.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        orders.setId(orders1.get().getId());
        orderService.save(orders);
        return new ResponseEntity<>(orders, HttpStatus.CREATED);
    }


}
