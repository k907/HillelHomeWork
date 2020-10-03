package Lesson_16;

//  ANSI кода для цветов
public enum Colors {

    BLACK("\u001B[30m"),
    RED("\u001B[31m"),
    GREEN("\u001B[32m"),
    YELLOW("\u001B[33m"),
    BLUE("\u001B[34m"),
    PURPLE("\u001B[35m"),
    CYAN("\u001B[36m"),
    WHITE("\u001B[37m");

    private String codeColor;

    Colors(String code) {
        this.codeColor = code;
    }

    public String getCodeColor() {
        return codeColor;
    }
}
