package todo;

import java.util.List;

public class TaskManager {
    String printTaskList(List<String> tasks) {
        StringBuilder taskList = new StringBuilder();
        for (int i = 0; i < tasks.size(); i++) {
            taskList.append(i + 1).append(". ").append(tasks.get(i)).append("\n");
        }
        return taskList.toString();
    }
}
