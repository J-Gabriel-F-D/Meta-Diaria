package br.com.j_gabriel_f_d.Meta_Diaria_backend.service;

import java.util.List;
import br.com.j_gabriel_f_d.Meta_Diaria_backend.model.Task;

public interface TaskService {
    Task create(Task task);
    Task update(Long id, Task task);
    Task findById(Long id);
    List<Task> findAll();
    void delete(Long id);
}
