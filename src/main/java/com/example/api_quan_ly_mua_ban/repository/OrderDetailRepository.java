package com.example.api_quan_ly_mua_ban.repository;

import com.example.api_quan_ly_mua_ban.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail,Long> {
    List<OrderDetail> findAllById(Long Id);
}
