package Task2;

public class AbstractFigure {
    String backgroundColor;
    String borderColor;

    public AbstractFigure(String backgroundColor, String borderColor) {
        this.backgroundColor = backgroundColor;
        this.borderColor = borderColor;
    }

    String getBackgroundColor() {
        return backgroundColor;
    }

    String getBorderColor() {
        return borderColor;
    }

    @Override
    public String toString() {
        return ", Цвет фона - " + getBackgroundColor() + ", Цвет границ - " + getBorderColor();
    }
}
