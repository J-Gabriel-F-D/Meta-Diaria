package br.com.j_gabriel_f_d.Meta_Diaria_backend.dto.task;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TaskRequest {

    @NotBlank
    private String title;

    private String description;
}
