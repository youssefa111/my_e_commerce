package com.youssefhussien.my_e_commerce.project.vo;


import lombok.*;

import java.util.Date;

@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductInventoryQueryVO {
    //   private Integer id;

    private String name;

    private Long quantity;

}
