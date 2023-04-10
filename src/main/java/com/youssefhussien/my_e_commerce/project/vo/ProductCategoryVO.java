package com.youssefhussien.my_e_commerce.project.vo;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;


@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductCategoryVO {
    //     @NotNull(message = "id can not null")
    //   private Integer id;

    private String name;

    private String desc;

}
