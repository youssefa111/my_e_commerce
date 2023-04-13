package com.youssefhussien.my_e_commerce.project.controller;

import com.youssefhussien.my_e_commerce.project.dto.OrderItemsDTO;
import com.youssefhussien.my_e_commerce.project.services.OrderItemsService;
import com.youssefhussien.my_e_commerce.project.vo.OrderItemsQueryVO;
import com.youssefhussien.my_e_commerce.project.vo.OrderItemsUpdateVO;
import com.youssefhussien.my_e_commerce.project.vo.OrderItemsVO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("${baseUrl}/orderItems")
public class OrderItemsController {

    @Autowired
    private OrderItemsService orderItemsService;

    @PostMapping
    public String save(@Valid @RequestBody OrderItemsVO vO) {
        return orderItemsService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        orderItemsService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody OrderItemsUpdateVO vO) {
        orderItemsService.update(id, vO);
    }

    @GetMapping("/{id}")
    public OrderItemsDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return orderItemsService.getById(id);
    }

    @GetMapping
    public Page<OrderItemsDTO> query(@Valid OrderItemsQueryVO vO) {
        return orderItemsService.query(vO);
    }
}
