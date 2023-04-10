package com.youssefhussien.my_e_commerce.core;

import com.youssefhussien.my_e_commerce.auth.role.entity.Role;
import com.youssefhussien.my_e_commerce.core.constant.RoleType;
import com.youssefhussien.my_e_commerce.auth.role.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class StartupApplication implements CommandLineRunner {

    @Autowired
    private RoleService roleService;

    @Override
    public void run(String... args) throws Exception {

        if(roleService.findAll().isEmpty()){
            Role role1 = new Role();
            role1.setRoleType(RoleType.ADMIN);
            Role role2 = new Role();
            role2.setRoleType(RoleType.CUSTOMER);
            Role role3 = new Role();
            role3.setRoleType(RoleType.MERCHANT);
            roleService.insert(Arrays.asList(role1,role2,role3));
        }
    }
}
