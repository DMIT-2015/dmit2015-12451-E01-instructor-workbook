package dmit2015.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.datafaker.Faker;

import java.util.UUID;
import java.util.random.RandomGenerator;

@Data
@NoArgsConstructor
@Entity
public class Task {

    @Id
    @Column(name="taskid",unique = true, nullable = false)
    private String id;  // unique identifier

    @NotBlank(message = "Description value cannot be blank")
    private String description;

    @Pattern(regexp = "^(Low|Medium|High)$", message="Priority must be Low, Medium, or High")
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

    public static Task of(Faker faker) {
        var randomGenerator = RandomGenerator.getDefault();
        String[] availablePriorities = new String[]{ "Low","Medium","High" };
        var currentTask = new Task();
        currentTask.setId(UUID.randomUUID().toString());
        currentTask.setDescription(faker.starWars().quotes());
        currentTask.setPriority(availablePriorities[randomGenerator.nextInt(availablePriorities.length)]);
        return currentTask;
    }
}
