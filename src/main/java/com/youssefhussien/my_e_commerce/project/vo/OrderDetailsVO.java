package com.youssefhussien.my_e_commerce.project.vo;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.Date;


public class OrderDetailsVO {
    @NotNull(message = "id can not null")
    private Integer id;

    private Integer paymentId;

    @NotNull(message = "userId can not null")
    private Long userId;

    private BigDecimal total;

    private Date createdAt;

    private Date modifiedAt;

}
