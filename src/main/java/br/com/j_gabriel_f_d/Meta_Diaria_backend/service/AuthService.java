package br.com.j_gabriel_f_d.Meta_Diaria_backend.service;

import org.springframework.stereotype.Service;

import br.com.j_gabriel_f_d.Meta_Diaria_backend.dto.auth.AuthResponse;
import br.com.j_gabriel_f_d.Meta_Diaria_backend.dto.auth.LoginRequest;
import br.com.j_gabriel_f_d.Meta_Diaria_backend.dto.auth.RegisterRequest;
import br.com.j_gabriel_f_d.Meta_Diaria_backend.model.User;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserService userService;
    private final JwtService jwtService;

    public void register(RegisterRequest dto) {
        userService.register(dto);
    }

    public AuthResponse login(LoginRequest dto) {
        User user = userService.authenticate(dto.getEmail(), dto.getPassword());
        String token = jwtService.generateToken(user);
        return new AuthResponse(token);
    }
}
