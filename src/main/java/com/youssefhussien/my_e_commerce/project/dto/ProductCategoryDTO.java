package com.youssefhussien.my_e_commerce.project.dto;


import lombok.*;

import java.util.Date;

@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductCategoryDTO {
    private Integer id;

    private String name;

    private String desc;

}
