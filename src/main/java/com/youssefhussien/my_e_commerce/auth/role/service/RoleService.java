package com.youssefhussien.my_e_commerce.auth.role.service;

import com.youssefhussien.my_e_commerce.auth.role.entity.Role;
import com.youssefhussien.my_e_commerce.auth.role.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository repository;


    public List<Role> findAll(){
        return repository.findAll();
    }

    public List<Role> insert(List<Role> entity){

        return repository.saveAll(entity);
    }
}
