package com.youssefhussien.my_e_commerce.auth.role.repository;

import com.youssefhussien.my_e_commerce.auth.role.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Short> {
}
