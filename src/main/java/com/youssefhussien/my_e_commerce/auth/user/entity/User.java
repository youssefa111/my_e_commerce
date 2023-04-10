package com.youssefhussien.my_e_commerce.auth.user.entity;


import com.youssefhussien.my_e_commerce.auth.role.entity.Role;
import com.youssefhussien.my_e_commerce.auth.token.entity.Token;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
@DynamicInsert
@DynamicUpdate
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Long id;

    @Column(name = "first_name",length = 30, nullable = false)
    private String firstName;
    @Column(name = "last_name",length = 30 , nullable = false)
    private String lastName;

    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "join_date", nullable = false)
    private LocalDate  joinDate;


    @Column(length = 30 , nullable = false)
    private String address;
    @Column(length = 11 , nullable = false)
    private String phone1;
    @Column(length = 11)
    private String phone2;
    @Column(length = 30, nullable = false)
    private String username;
    @Email
    @Column(length = 50, nullable = false)
    private String email;
    @Column( nullable = false)
    private String password;
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;
    @OneToMany(mappedBy = "user")
    private List<Token> tokens;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(role != null)
        return List.of(new SimpleGrantedAuthority(role.getRoleType().name()));
        else
            return null;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
