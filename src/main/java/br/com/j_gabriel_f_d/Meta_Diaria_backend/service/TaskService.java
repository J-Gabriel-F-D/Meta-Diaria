package br.com.j_gabriel_f_d.Meta_Diaria_backend.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.j_gabriel_f_d.Meta_Diaria_backend.model.Task;
import br.com.j_gabriel_f_d.Meta_Diaria_backend.model.User;
import br.com.j_gabriel_f_d.Meta_Diaria_backend.repository.TaskRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskResponseDTO create(TaskRequestDTO dto, User user) {
        Task task = new Task(
                null,
                dto.title(),
                dto.description(),
                false,
                LocalDateTime.now(),
                user
        );

        taskRepository.save(task);
        return toDTO(task);
    }

    public List<TaskResponseDTO> list(User user) {
        return taskRepository.findByUserId(user.getId())
                .stream()
                .map(this::toDTO)
                .toList();
    }

    public TaskResponseDTO update(String id, TaskRequestDTO dto, User user) {
        Task task = findUserTask(id, user);

        task.setTitle(dto.title());
        task.setDescription(dto.description());

        taskRepository.save(task);
        return toDTO(task);
    }

    public TaskResponseDTO toggleCompleted(String id, User user) {
        Task task = findUserTask(id, user);
        task.setCompleted(!task.isCompleted());

        taskRepository.save(task);
        return toDTO(task);
    }

    public void delete(String id, User user) {
        Task task = findUserTask(id, user);
        taskRepository.delete(task);
    }

    private Task findUserTask(String id, User user) {
        return taskRepository.findByIdAndUserId(id, user.getId())
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada."));
    }

    private TaskResponseDTO toDTO(Task task) {
        return new TaskResponseDTO(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.isCompleted(),
                task.getCreatedAt()
        );
    }
}
