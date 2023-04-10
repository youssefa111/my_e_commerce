package com.youssefhussien.my_e_commerce.auth.user.dto;

import com.youssefhussien.my_e_commerce.auth.role.dto.RoleDto;
import com.youssefhussien.my_e_commerce.auth.token.dto.TokenDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
//@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegisterDto {

    @NotBlank
    @Size(min = 3 , max = 30)
    private String firstName;
    @NotBlank
    @Size(min = 3 , max = 30)
    private String lastName;

    @NotNull
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate dateOfBirth;
    @NotNull
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate joinDate;
    @NotBlank
    @Size(min = 3 , max = 30)
    private String address;
    @NotBlank
    @Size(min = 11 , max = 11)
    private String phone1;
//    @NotBlank
//    @Size(min = 11 , max = 11)
    private String phone2;
    @NotBlank
    @Size(min = 3 , max = 30)
    private String username;
    @Email
    @NotBlank
    private String email;
    @NotBlank
    @Size(min = 7 , max = 30)
    private String password;

    @NotNull
    private RoleDto role;

    private TokenDto token;

}
