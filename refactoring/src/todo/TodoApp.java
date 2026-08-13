package todo;

import java.util.ArrayList;
import java.util.List;

import ch.trick17.gui.Color;
import ch.trick17.gui.Gui;
import ch.trick17.gui.widget.TextField;
import ch.trick17.gui.widget.Button;

/**
 * Simple To-Do List application
 *
 * Currently you can create new tasks and add them to the list and clear the whole list.
 *
 * ToDo:
 * - mark tasks as done
 * - add due date to tasks
 * - sort tasks according to state (not done) and due date
 * - don't show finished tasks in the task list
 * - show a separate view with finished task with date when finished
 * - ...
 */
public class TodoApp {

    private final List<String> tasks = new ArrayList<>();
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;
    private final Gui gui = Gui.create("Todo List", WIDTH, HEIGHT);
    private String currentTask = "";
    private TaskManager taskManager;

    public static void main(String[] args) {
        new TodoApp().createAndShowGUI();
    }

    private void createAndShowGUI() {
        gui.setFontSize(16);

        var textField = new TextField(10, 10, 380, 30) {
            protected void onTextChange(String text) {
                currentTask = text;
            }
        };
        textField.setTextColor(new Color(100, 100, 100));
        textField.setText("Add new Task");
        textField.setTextColor(new Color(0, 0, 0));

        var textArea = new TextArea(10, 20 + textField.getHeight(), 380, 200);
        taskManager = new TaskManager();
        textArea.setText(taskManager.printTaskList(tasks));

        var addButton = new Button("Add", WIDTH - 120, HEIGHT - 40, 50, 30) {

            public void onLeftClick(double _x, double _y) {
                if (!currentTask.isEmpty()) {
                    tasks.add(currentTask);
                }

                textArea.setText(taskManager.printTaskList(tasks));
                currentTask = "";
                textField.setText("");
            }
        };
        var clearButton = new Button("Clear", WIDTH - 60, HEIGHT - 40, 50, 30) {
            public void onLeftClick(double _x, double _y) {
                tasks.clear();
                currentTask = "";
                textField.setTextColor(new Color(100, 100, 100));
                textField.setText("Add new Task");
                textArea.setText("");

            }
        };
        gui.addComponents(textField, textArea, addButton, clearButton);
        gui.open();
        gui.runUntilClosed();
    }


}
