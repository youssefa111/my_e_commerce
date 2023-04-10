package com.youssefhussien.my_e_commerce.project.repository;

import com.youssefhussien.my_e_commerce.project.entites.PaymentDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentDetailsRepository extends JpaRepository<PaymentDetail, Integer> {
}