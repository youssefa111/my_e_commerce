package com.youssefhussien.my_e_commerce.project.vo;


import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductQueryVO {
    //    private Integer id;

    private String name;

    private Integer categoryId;

    private Integer inventoryId;

    private Integer discountId;

    private BigDecimal price;

    private String desc;

}
