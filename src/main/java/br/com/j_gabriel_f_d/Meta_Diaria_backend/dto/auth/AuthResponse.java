package br.com.j_gabriel_f_d.Meta_Diaria_backend.dto.auth;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponse {
    private String token;
}