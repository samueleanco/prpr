package todo;

import ch.trick17.gui.Color;
import ch.trick17.gui.Gui;
import ch.trick17.gui.component.Drawable;

/**
 * First implementation of a TextArea to show the tasklist.
 * <p>
 * Todo for a general TextArea
 * - make font size adjustable, resp. adapt to font size
 * - make scrollable when text size longer than height
 * <p>
 * Possible tasks for a custom, specific task area
 * - write tasks line per line
 * - format tasks with due date and show status
 * -
 */
class TextArea implements Drawable {
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
