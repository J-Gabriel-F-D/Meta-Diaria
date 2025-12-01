package br.com.j_gabriel_f_d.Meta_Diaria_backend.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.j_gabriel_f_d.Meta_Diaria_backend.model.User;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String email);
}