package com.youssefhussien.my_e_commerce.project.controller;

import com.youssefhussien.my_e_commerce.project.dto.ProductInventoryDTO;
import com.youssefhussien.my_e_commerce.project.services.ProductInventoryService;
import com.youssefhussien.my_e_commerce.project.vo.ProductInventoryQueryVO;
import com.youssefhussien.my_e_commerce.project.vo.ProductInventoryUpdateVO;
import com.youssefhussien.my_e_commerce.project.vo.ProductInventoryVO;
import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("${baseUrl}/productInventory")
public class ProductInventoryController {

    @Autowired
    private ProductInventoryService productInventoryService;

    @PostMapping
    public String save(@Valid @RequestBody ProductInventoryVO vO) {
        return productInventoryService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        productInventoryService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody ProductInventoryUpdateVO vO) {
        productInventoryService.update(id, vO);
    }

    @GetMapping("/{id}")
    public ProductInventoryDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return productInventoryService.getById(id);
    }

    @GetMapping
    public Page<ProductInventoryDTO> query(@Valid ProductInventoryQueryVO vO) {
        return productInventoryService.query(vO);
    }
}
