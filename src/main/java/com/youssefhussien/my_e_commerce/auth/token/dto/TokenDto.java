package com.youssefhussien.my_e_commerce.auth.token.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TokenDto {

    private String token;
    private Date expireDate;
}
