package student.task.task_manager.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import student.task.task_manager.entity.TaskStatus;

@Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor

    public class TaskDto {
        private Long id;
        @NotBlank(message = "Title cannot be empty")
        private String title;

        @NotBlank(message = "Description cannot be empty")
        private String description;

        @NotNull(message = "Status cannot be empty")
        private TaskStatus status;
}
