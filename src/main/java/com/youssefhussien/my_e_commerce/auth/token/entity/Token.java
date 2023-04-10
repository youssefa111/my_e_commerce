package com.youssefhussien.my_e_commerce.auth.token.entity;

import com.youssefhussien.my_e_commerce.auth.user.entity.User;
import com.youssefhussien.my_e_commerce.core.constant.TokenType;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String token;

    @Column(name = "expire_date")
    private Date expireDate;

    @Enumerated(EnumType.STRING)
    @Column(length = 30)
    private TokenType tokenType;

    private boolean expired;

    private boolean revoked;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
