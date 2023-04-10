package com.youssefhussien.my_e_commerce.project.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.youssefhussien.my_e_commerce.project.entites.Discount;
import com.youssefhussien.my_e_commerce.project.entites.ProductCategory;
import com.youssefhussien.my_e_commerce.project.entites.ProductInventory;
import lombok.*;

import java.math.BigDecimal;

@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDTO {
    private Integer id;

    private String name;

    private ProductCategoryDTO category;

    private ProductInventoryDTO inventory;

    private DiscountDTO discount;

    private BigDecimal price;

    private BigDecimal afterDiscount;

    private String desc;

}
