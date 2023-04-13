package com.youssefhussien.my_e_commerce.project.controller;

import com.youssefhussien.my_e_commerce.core.constant.AppConstants;
import com.youssefhussien.my_e_commerce.project.dto.ProductCategoryDTO;
import com.youssefhussien.my_e_commerce.project.services.ProductCategoryService;
import com.youssefhussien.my_e_commerce.project.vo.ProductCategoryQueryVO;
import com.youssefhussien.my_e_commerce.project.vo.ProductCategoryUpdateVO;
import com.youssefhussien.my_e_commerce.project.vo.ProductCategoryVO;
import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("${baseUrl}/productCategory")
@Secured(AppConstants.ADMIN)
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;

    @PostMapping
    public String save(@Valid @RequestBody ProductCategoryVO vO) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("eeee "+auth.getAuthorities().toString());
        return productCategoryService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        productCategoryService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody ProductCategoryUpdateVO vO) {
        productCategoryService.update(id, vO);
    }

    @GetMapping("/{id}")
    public ProductCategoryDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return productCategoryService.getById(id);
    }
    @GetMapping()
    @Secured({AppConstants.ADMIN,AppConstants.CUSTOMER,AppConstants.MERCHANT})
    public List<ProductCategoryDTO> findAll() {
        return productCategoryService.findAll();
    }


//    @GetMapping
//    public Page<ProductCategoryDTO> query(@Valid ProductCategoryQueryVO vO) {
//        return productCategoryService.query(vO);
//    }
}
