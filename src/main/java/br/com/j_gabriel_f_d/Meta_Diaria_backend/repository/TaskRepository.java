package br.com.j_gabriel_f_d.Meta_Diaria_backend.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import br.com.j_gabriel_f_d.Meta_Diaria_backend.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
