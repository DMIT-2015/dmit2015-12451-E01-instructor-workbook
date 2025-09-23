package dmit2015.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Task {

    private String id;  // unique identifier
    private String description;
    private String priority;    // Low, Medium, High
    private boolean done;

    // Copy constructor
    public Task(Task other) {
        this.id = other.getId();
        this.description = other.getDescription();
        this.priority = other.getPriority();
        this.done = other.isDone();
    }

    public static Task copyOf(Task other) {
        return new Task(other);
    }
}
