package student.task.task_manager.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import student.task.task_manager.dto.TaskDto;
import student.task.task_manager.entity.Task;
import student.task.task_manager.mapper.TaskMapper;
import student.task.task_manager.service.TaskService;
import student.task.task_manager.entity.TaskStatus;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping
    public List<TaskDto> getAllTasks() {

        List<Task> tasks = service.getAllTasks();

        List<TaskDto> dtos = new ArrayList<>();

        for (Task task : tasks) {
            TaskDto dto = TaskMapper.toDto(task);
            dtos.add(dto);
        }

        return dtos;
    }
    @GetMapping("/status/{status}")
    public List<TaskDto> getTasksByStatus(@PathVariable TaskStatus status) {

        List<Task> tasks = service.getTasksByStatus(status);

        List<TaskDto> dtos = new ArrayList<>();

        for (Task task : tasks) {
            TaskDto dto = TaskMapper.toDto(task);
            dtos.add(dto);
        }

        return dtos;
    }
    @GetMapping("/title/{title}")
    public List<TaskDto> getTasksByTitle(@PathVariable String title) {

        List<Task> tasks = service.getTasksByTitle(title);

        List<TaskDto> dtos = new ArrayList<>();

        for (Task task : tasks) {
            TaskDto dto = TaskMapper.toDto(task);
            dtos.add(dto);
        }

        return dtos;
    }

    @PostMapping
    public TaskDto createTask(@RequestBody TaskDto dto) {

        Task task = TaskMapper.toEntity(dto);

        Task savedTask = service.createTask(task);

        return TaskMapper.toDto(savedTask);
    }

    @GetMapping("/{id}")
    public TaskDto getTaskById(@PathVariable Long id) {

        Task task = service.getTaskById(id);

        return TaskMapper.toDto(task);
    }

    @PutMapping("/{id}")
    public TaskDto updateTask(
            @PathVariable Long id,
            @Valid
            @RequestBody TaskDto dto) {

        Task task = TaskMapper.toEntity(dto);

        Task updatedTask = service.updateTask(id, task);

        return TaskMapper.toDto(updatedTask);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        service.deleteTask(id);
    }
}