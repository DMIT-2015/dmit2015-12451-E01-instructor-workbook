package dmit2015.faces;

import dmit2015.model.Task;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.omnifaces.util.Messages;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Session-scoped backing bean: per-user state that persists for the HTTP session.
 * Implements Serializable for passivation.
 */
@Named("taskManagerSession")
@SessionScoped // Lives for the user's session; store only per-user state
public class TaskManagerSession implements Serializable {
    private static final long serialVersionUID = 1L;

    private static final Logger LOG = Logger.getLogger(TaskManagerSession.class.getName());

    @Getter
    @Setter
    private Task newTask = new Task();  // The Task to add

    @Getter
    private List<Task> tasks = new ArrayList<Task>();   // List of Task

    // ActionListener method to handle request to add a new Task
    public void addTask() {
        tasks.add(newTask);
        Messages.addGlobalInfo("Added task {0}", newTask);
        // create another Task to add
        newTask = new Task();
    }

    // ActionListener method to remove a Task
    public void removeTask(Task currentTask) {
        tasks.remove(currentTask);
        Messages.addGlobalInfo("Removed task {0}", currentTask);
    }

}
