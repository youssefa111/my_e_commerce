package com.youssefhussien.my_e_commerce.project.vo;


import lombok.*;

import java.util.Date;

@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDetailsQueryVO {
    //  private Integer id;

    private Integer sessionId;

    private String provider;

    private Integer status;


}
