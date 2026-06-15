package student.task.task_manager.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String description;

@Enumerated(EnumType.STRING)
    private TaskStatus status;

}