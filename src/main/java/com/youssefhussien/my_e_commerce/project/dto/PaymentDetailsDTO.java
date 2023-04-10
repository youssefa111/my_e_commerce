package com.youssefhussien.my_e_commerce.project.dto;


import lombok.*;

import java.util.Date;

@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDetailsDTO {
    private Integer id;

    private Integer orderId;

    private String provider;

    private Integer status;

}
