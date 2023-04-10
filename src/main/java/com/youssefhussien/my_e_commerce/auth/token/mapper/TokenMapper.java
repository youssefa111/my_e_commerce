package com.youssefhussien.my_e_commerce.auth.token.mapper;

import com.youssefhussien.my_e_commerce.auth.token.dto.TokenDto;
import com.youssefhussien.my_e_commerce.auth.token.entity.Token;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface TokenMapper {
    Token toEntity(TokenDto tokenDto);

    TokenDto toDto(Token token);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Token partialUpdate(TokenDto tokenDto, @MappingTarget Token token);
}