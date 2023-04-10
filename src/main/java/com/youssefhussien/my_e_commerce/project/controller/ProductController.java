package com.youssefhussien.my_e_commerce.project.controller;

import com.youssefhussien.my_e_commerce.core.constant.AppConstants;
import com.youssefhussien.my_e_commerce.project.dto.ProductCategoryDTO;
import com.youssefhussien.my_e_commerce.project.dto.ProductDTO;
import com.youssefhussien.my_e_commerce.project.services.ProductService;
import com.youssefhussien.my_e_commerce.project.vo.ProductUpdateVO;
import com.youssefhussien.my_e_commerce.project.vo.ProductVO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("${baseUrl}/product")
@Secured("MERCHANT")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public String save(@Valid @RequestBody ProductVO vO) {
        return productService.save(vO).toString();
    }

    @PostMapping("/saveAll")
    public List<Integer> saveALL(@Valid @RequestBody List<ProductVO> vO) {
        return productService.saveAll(vO);
    }

    @DeleteMapping("/{id}")
    @Secured({"MERCHANT","ADMIN"})
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        productService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody ProductUpdateVO vO) {
        productService.update(id, vO);
    }

    @GetMapping("/{id}")
    @Secured({AppConstants.ADMIN,AppConstants.CUSTOMER,AppConstants.MERCHANT})
    public ProductDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return productService.getById(id);
    }

    @GetMapping()
    @Secured({AppConstants.ADMIN,AppConstants.CUSTOMER,AppConstants.MERCHANT})
    public List<ProductDTO> findAll() {
        return productService.findAll();
    }
    @GetMapping("catId/{id}")
    @Secured({AppConstants.ADMIN,AppConstants.CUSTOMER,AppConstants.MERCHANT})
    public List<ProductDTO> findByCategory(@Valid @NotNull @PathVariable("id") Integer id) {
        return productService.findByCategory(id);
    }


//    @GetMapping
//    public Page<ProductDTO> query(@Valid ProductQueryVO vO) {
//        return productService.query(vO);
//    }
}
