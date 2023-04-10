package com.youssefhussien.my_e_commerce.project.controller;

import com.youssefhussien.my_e_commerce.project.dto.PaymentDetailsDTO;
import com.youssefhussien.my_e_commerce.project.services.PaymentDetailsService;
import com.youssefhussien.my_e_commerce.project.vo.PaymentDetailsQueryVO;
import com.youssefhussien.my_e_commerce.project.vo.PaymentDetailsUpdateVO;
import com.youssefhussien.my_e_commerce.project.vo.PaymentDetailsVO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("${baseUrl}/paymentDetails")
public class PaymentDetailsController {

    @Autowired
    private PaymentDetailsService paymentDetailsService;

    @PostMapping
    public String save(@Valid @RequestBody PaymentDetailsVO vO) {
        return paymentDetailsService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        paymentDetailsService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody PaymentDetailsUpdateVO vO) {
        paymentDetailsService.update(id, vO);
    }

    @GetMapping("/{id}")
    public PaymentDetailsDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return paymentDetailsService.getById(id);
    }

    @GetMapping
    public Page<PaymentDetailsDTO> query(@Valid PaymentDetailsQueryVO vO) {
        return paymentDetailsService.query(vO);
    }
}
