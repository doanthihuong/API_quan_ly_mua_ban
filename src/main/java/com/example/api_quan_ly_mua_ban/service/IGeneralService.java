package com.example.api_quan_ly_mua_ban.service;



import java.util.Optional;

public interface IGeneralService<T> { // interface sử dụng generic mô tả các phương chung mà tất cả các service cần có

    Iterable<T> findAll();

    Optional<T> findById(Long id);

    T save(T orders);

    void remove(Long id);
}
