package todo;

import java.util.ArrayList;
import java.util.List;

import ch.trick17.gui.Color;
import ch.trick17.gui.Gui;
import ch.trick17.gui.component.Drawable;
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
        textArea.setText(printTaskList());

        var addButton = new Button("Add", WIDTH - 120, HEIGHT - 40, 50, 30) {
            public void onLeftClick(double _x, double _y) {
                if (!currentTask.isEmpty()) {
                    tasks.add(currentTask);
                }
                textArea.setText(printTaskList());
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


    private String printTaskList() {
        StringBuilder taskList = new StringBuilder();
        for (int i = 0; i < tasks.size(); i++) {
            taskList.append(i + 1).append(". ").append(tasks.get(i)).append("\n");
        }
        return taskList.toString();
    }

    /**
     * First implementation of a TextArea to show the tasklist.
     *
     * Todo for a general TextArea
     * - make font size adjustable, resp. adapt to font size
     * - make scrollable when text size longer than height
     *
     * Possible tasks for a custom, specific task area
     * - write tasks line per line
     * - format tasks with due date and show status
     * -
     */
    static class TextArea implements Drawable {
        public static final Color DEFAULT_BORDER_COLOR = new Color(178, 188, 203);

        private final double x;
        private final double y;
        private final double width;
        private final double height;
        String text;

        TextArea(double x, double y, double width, double height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;

        }

        public void setText(String text) {
            this.text = text;
        }

        @Override
        public void draw(Gui gui) {
            gui.setColor(DEFAULT_BORDER_COLOR);
            gui.drawRect(x, y, width, height);
            gui.setColor(0, 0, 0);
            gui.setFontSize(16);
            gui.setLineSpacing(1.5);
            gui.setTextAlignLeft();
            // x + 5 similar to TextField Implementation
            gui.drawString(text, x + 5, y + 20);
        }
    }
}
