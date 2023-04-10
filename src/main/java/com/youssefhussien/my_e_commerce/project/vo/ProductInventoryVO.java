package com.youssefhussien.my_e_commerce.project.vo;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductInventoryVO {
    //  @NotNull(message = "id can not null")
    //   private Integer id;

    @NotNull(message = "name can not null")
    private String name;

    @NotNull
    private Integer quantity;

}
