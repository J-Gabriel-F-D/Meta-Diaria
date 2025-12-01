package br.com.j_gabriel_f_d.Meta_Diaria_backend.dto.auth;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequest {

    @NotBlank
    private String email;

    @NotBlank
    private String password;
}