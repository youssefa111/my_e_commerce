package com.youssefhussien.my_e_commerce.project.repository;

import com.youssefhussien.my_e_commerce.project.entites.ProductInventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductInventoryRepository extends JpaRepository<ProductInventory, Integer> {
}