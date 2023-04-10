package com.youssefhussien.my_e_commerce.config;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor(){

        return Optional.of("text user");
    }
}
