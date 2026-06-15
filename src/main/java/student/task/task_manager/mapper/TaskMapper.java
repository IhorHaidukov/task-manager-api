package student.task.task_manager.mapper;


import student.task.task_manager.dto.TaskDto;
import student.task.task_manager.entity.Task;

public class TaskMapper {

    public static TaskDto toDto(Task task){
        return new TaskDto(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus()
        );

    }

    public static Task toEntity(TaskDto dto){
        Task task = new Task();

        task.setId(dto.getId());
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setStatus(dto.getStatus());

        return task;
    }
}
