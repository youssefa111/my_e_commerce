package com.youssefhussien.my_e_commerce.project.vo;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;


@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailsVO {

    private Integer paymentId;

    @NotNull(message = "userId can not null")
    private Long userId;

    private BigDecimal total;

}
