package com.youssefhussien.my_e_commerce.project.repository;

import com.youssefhussien.my_e_commerce.project.entites.Discount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountRepository extends JpaRepository<Discount, Integer> {
}