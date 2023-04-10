package com.youssefhussien.my_e_commerce.project.vo;

import jakarta.validation.constraints.NotNull;
import jdk.jfr.Unsigned;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductVO {
    //   @NotNull(message = "id can not null")
    //   private Integer id;

    @NotNull
    private String name;

    @NotNull
    private Integer category;

    @NotNull
    private ProductInventoryVO inventory;

    private DiscountVO discount;

    @NotNull
    @Unsigned
    private BigDecimal price;

    private String desc;

}
