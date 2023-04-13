package com.youssefhussien.my_e_commerce.project.vo;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jdk.jfr.Unsigned;
import lombok.*;

import java.util.Date;


@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemsVO {

    @NotNull(message = "productId can not null")
    private Integer productId;

    @NotNull
    @Min(value = 1)
    private Integer quantity;
}
