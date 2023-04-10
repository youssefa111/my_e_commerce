package com.youssefhussien.my_e_commerce.auth.role.dto;

import com.youssefhussien.my_e_commerce.core.constant.RoleType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleDto {

    private Short id;

//    @Enumerated(EnumType.STRING)
//    private RoleType roleType;

}
