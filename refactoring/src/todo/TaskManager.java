package todo;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {

    private final List<String> tasks = new ArrayList<>();

    public void addTask(String task) {
        if (!task.isEmpty()) {
            tasks.add(task);
        }
    }

    public void clear() {
        tasks.clear();
    }

    public String printTaskList() {
        StringBuilder taskList = new StringBuilder();
        for (int i = 0; i < tasks.size(); i++) {
            taskList.append(i + 1).append(". ").append(tasks.get(i)).append("\n");
        }
        return taskList.toString();
    }
}