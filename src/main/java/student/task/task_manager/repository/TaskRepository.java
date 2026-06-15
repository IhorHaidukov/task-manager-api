package student.task.task_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import  student.task.task_manager.entity.Task;
import student.task.task_manager.entity.TaskStatus;



import java.util.List;

public interface
TaskRepository  extends JpaRepository<Task,Long> {
    List<Task> findByStatus(TaskStatus status);
    List<Task> findByTitleContainingIgnoreCase(String title);
}
