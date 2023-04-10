package com.youssefhussien.my_e_commerce.project.vo;

import jakarta.validation.constraints.NotNull;

import java.util.Date;


public class OrderItemsVO {
    @NotNull(message = "id can not null")
    private Integer id;

    @NotNull(message = "orderId can not null")
    private Integer orderId;

    @NotNull(message = "productId can not null")
    private Integer productId;

    private Integer quantity;

    private Date createdAt;

    private Date modifiedAt;

}
