package com.youssefhussien.my_e_commerce.project.repository;

import com.youssefhussien.my_e_commerce.project.entites.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByCategory(Integer id);
}