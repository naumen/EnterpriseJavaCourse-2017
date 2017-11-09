package _1_singleton;

public class Display {

    private Display(){ /* инициализация*/ }

    public static final Display INSTANCE = new Display();

    public void draw(Object obj){ /* отображаем */ }
}
