package student.task.task_manager.service;

import org.springframework.stereotype.Service;
import student.task.task_manager.entity.Task;
import student.task.task_manager.entity.TaskStatus;
import student.task.task_manager.exception.TaskNotFoundException;
import student.task.task_manager.repository.TaskRepository;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    public Task createTask(Task task) {
        return repository.save(task);
    }

    public Task getTaskById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new TaskNotFoundException("Task not found"));
    }

    public void deleteTask(Long id) {
        repository.deleteById(id);
    }

    public Task updateTask(Long id, Task task) {

        Task existingTask =
                repository.findById(id)
                        .orElseThrow(() ->
                                new TaskNotFoundException("Task not found"));
        existingTask.setTitle(task.getTitle());
        existingTask.setDescription(task.getDescription());
        existingTask.setStatus(task.getStatus());

        return repository.save(existingTask);
    }

    public List<Task> getTasksByStatus(TaskStatus status) {
        return repository.findByStatus(status);
    }
    public List<Task> getTasksByTitle(String title) {
        return repository.findByTitleContainingIgnoreCase(title);
    }
}
