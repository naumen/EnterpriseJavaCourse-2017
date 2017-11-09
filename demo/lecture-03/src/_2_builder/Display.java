package _2_builder;

public class Display {

    private Display(){
        // инициализация
    }

    public static Display INSTANCE = new Display();

    public void draw(Object obj){
        // отображаем
    }
}
