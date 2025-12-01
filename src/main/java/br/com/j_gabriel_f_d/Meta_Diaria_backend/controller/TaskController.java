package br.com.j_gabriel_f_d.Meta_Diaria_backend.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.j_gabriel_f_d.Meta_Diaria_backend.model.User;
import br.com.j_gabriel_f_d.Meta_Diaria_backend.service.TaskService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskResponseDTO> create(
            @RequestBody @Valid TaskRequestDTO dto,
            @AuthenticationPrincipal User user
    ) {
        return ResponseEntity.status(201).body(taskService.create(dto, user));
    }

    @GetMapping
    public ResponseEntity<List<TaskResponseDTO>> list(
            @AuthenticationPrincipal User user
    ) {
        return ResponseEntity.ok(taskService.list(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> update(
            @PathVariable String id,
            @RequestBody @Valid TaskRequestDTO dto,
            @AuthenticationPrincipal User user
    ) {
        return ResponseEntity.ok(taskService.update(id, dto, user));
    }

    @PatchMapping("/{id}/toggle")
    public ResponseEntity<TaskResponseDTO> toggle(
            @PathVariable String id,
            @AuthenticationPrincipal User user
    ) {
        return ResponseEntity.ok(taskService.toggleCompleted(id, user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable String id,
            @AuthenticationPrincipal User user
    ) {
        taskService.delete(id, user);
        return ResponseEntity.noContent().build();
    }
}
