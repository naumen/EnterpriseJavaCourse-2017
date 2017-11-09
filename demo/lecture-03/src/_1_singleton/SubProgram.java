package _1_singleton;

public class SubProgram {

    public void doSomething(){
//        Display displayDuplicate = new Display();
        Display displaySingleton = Display.INSTANCE;
        displaySingleton.draw("Hello world");
    }
}
