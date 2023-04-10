package com.youssefhussien.my_e_commerce.auth.user.service;


import com.youssefhussien.my_e_commerce.auth.token.service.TokenService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LogoutService  implements LogoutHandler {
    private final TokenService tokenService;

    @Transactional
    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {

        final String authHeader = request.getHeader("Authorization");
        final String jwt;
        if(authHeader == null || !authHeader.startsWith("Bearer ")) {
            return;
        }

        jwt = authHeader.substring(7);
        var storedToken = tokenService.findByToken(jwt).orElse(null);
        if(storedToken != null){
            storedToken.setRevoked(true);
            storedToken.setExpired(true);
            tokenService.save(storedToken);
        }
    }
}
