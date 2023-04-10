package com.youssefhussien.my_e_commerce.project.dto;


import lombok.*;

import java.util.Date;

@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemsDTO {
    private Integer id;

    private Integer orderId;

    private Integer productId;

    private Integer quantity;

    private Date createdAt;

    private Date modifiedAt;

}
