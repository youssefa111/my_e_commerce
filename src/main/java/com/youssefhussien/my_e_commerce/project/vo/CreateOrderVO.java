package com.youssefhussien.my_e_commerce.project.vo;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderVO {

    @NotNull
    @Valid
    private OrderDetailsVO orderDetailsVO;

    @NotEmpty
    @Valid
    private List<OrderItemsVO> orderItemsVOList;

}
