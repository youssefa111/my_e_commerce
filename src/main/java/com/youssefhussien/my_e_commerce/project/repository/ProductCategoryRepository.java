package com.youssefhussien.my_e_commerce.project.repository;

import com.youssefhussien.my_e_commerce.project.entites.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {
}