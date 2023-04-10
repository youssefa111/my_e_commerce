package com.youssefhussien.my_e_commerce.project.dto;


import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DiscountDTO {
    private Integer id;

    private String name;

    private BigDecimal discountPercent;

    private Integer active;

    private String desc;

}
