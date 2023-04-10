package com.youssefhussien.my_e_commerce.project.controller;

import com.youssefhussien.my_e_commerce.core.constant.AppConstants;
import com.youssefhussien.my_e_commerce.project.dto.DiscountDTO;
import com.youssefhussien.my_e_commerce.project.services.DiscountService;
import com.youssefhussien.my_e_commerce.project.vo.DiscountQueryVO;
import com.youssefhussien.my_e_commerce.project.vo.DiscountUpdateVO;
import com.youssefhussien.my_e_commerce.project.vo.DiscountVO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("${baseUrl}/discount")
@Secured(AppConstants.MERCHANT)
public class DiscountController {

    @Autowired
    private DiscountService discountService;

    @PostMapping
    public String save(@Valid @RequestBody DiscountVO vO) {
        return discountService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        discountService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody DiscountUpdateVO vO) {
        discountService.update(id, vO);
    }

    @GetMapping("/{id}")
    public DiscountDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return discountService.getById(id);
    }

    @GetMapping
    public Page<DiscountDTO> query(@Valid DiscountQueryVO vO) {
        return discountService.query(vO);
    }
}
