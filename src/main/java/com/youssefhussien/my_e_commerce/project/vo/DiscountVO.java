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
public class
DiscountVO {
    //   @NotNull(message = "id can not null")
    //    private Integer id;

    @NotNull
    private String name;

    @NotNull
    @Unsigned
    private BigDecimal discountPercent;

    @NotNull
    private Integer productID;

    @NotNull
    private Integer active;

    private String desc;

}
