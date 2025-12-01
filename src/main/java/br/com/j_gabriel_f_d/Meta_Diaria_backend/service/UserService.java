package br.com.j_gabriel_f_d.Meta_Diaria_backend.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.j_gabriel_f_d.Meta_Diaria_backend.model.User;
import br.com.j_gabriel_f_d.Meta_Diaria_backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void register(RegisterDTO dto) {
        if (userRepository.existsByEmail(dto.email())) {
            throw new RuntimeException("Email já registrado.");
        }

        User user = new User(
                null,
                dto.email(),
                passwordEncoder.encode(dto.password())
        );

        userRepository.save(user);
    }

    public User authenticate(String email, String password) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Credenciais inválidas."));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Credenciais inválidas.");
        }

        return user;
    }
}

