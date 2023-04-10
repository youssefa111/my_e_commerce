package com.youssefhussien.my_e_commerce.auth.user.mapper;

import com.youssefhussien.my_e_commerce.auth.role.mapper.RoleMapper;
import com.youssefhussien.my_e_commerce.auth.token.mapper.TokenMapper;
import com.youssefhussien.my_e_commerce.auth.user.dto.RegisterDto;
import com.youssefhussien.my_e_commerce.auth.user.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {
              RoleMapper.class,
                TokenMapper.class
        }

)
public interface UserMapper {


    @Mapping(target = "password",ignore = true)
    RegisterDto toDto(User user);

    User toEntity (RegisterDto registerDto);

//    RegisterDto mapUserEntityToRegisterDto(User user);

}
