package com.youssefhussien.my_e_commerce.project.controller;

import com.youssefhussien.my_e_commerce.core.constant.AppConstants;
import com.youssefhussien.my_e_commerce.project.dto.OrderDetailsDTO;
import com.youssefhussien.my_e_commerce.project.services.OrderDetailsService;
import com.youssefhussien.my_e_commerce.project.vo.CreateOrderVO;
import com.youssefhussien.my_e_commerce.project.vo.OrderDetailsQueryVO;
import com.youssefhussien.my_e_commerce.project.vo.OrderDetailsUpdateVO;
import com.youssefhussien.my_e_commerce.project.vo.OrderDetailsVO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("${baseUrl}/order")
@Secured(AppConstants.CUSTOMER)
public class OrderDetailsController {

    @Autowired
    private OrderDetailsService orderDetailsService;

    @PostMapping
    public String save(@Valid @RequestBody CreateOrderVO vO) {
        return orderDetailsService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        orderDetailsService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody OrderDetailsUpdateVO vO) {
        orderDetailsService.update(id, vO);
    }

    @GetMapping("/{id}")
    public OrderDetailsDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return orderDetailsService.getById(id);
    }

    @GetMapping
    public Page<OrderDetailsDTO> query(@Valid OrderDetailsQueryVO vO) {
        return orderDetailsService.query(vO);
    }
}
