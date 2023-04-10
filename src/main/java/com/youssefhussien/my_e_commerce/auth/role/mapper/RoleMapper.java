package com.youssefhussien.my_e_commerce.auth.role.mapper;

import com.youssefhussien.my_e_commerce.auth.role.dto.RoleDto;
import com.youssefhussien.my_e_commerce.auth.role.entity.Role;
import org.mapstruct.*;

@Mapper(
//        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING)
public interface RoleMapper {
    Role toEntity(RoleDto roleDto);

    RoleDto toDto(Role role);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Role partialUpdate(RoleDto roleDto, @MappingTarget Role role);
}