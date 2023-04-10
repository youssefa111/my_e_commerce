package com.youssefhussien.my_e_commerce.project.dto;


import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailsDTO {
    private Integer id;

    private Integer paymentId;

    private Long userId;

    private BigDecimal total;

    private Date createdAt;

    private Date modifiedAt;

}
