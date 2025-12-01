package br.com.j_gabriel_f_d.Meta_Diaria_backend.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.j_gabriel_f_d.Meta_Diaria_backend.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAllByOwnerId(UUID ownerId);
    Optional<Task> findByIdAndOwnerId(Long id, UUID ownerId);
}
