package _1_singleton;

public class GoodSubProgram {

    public void doSomething(){
        Display displayDuplicate = new Display(); // ! не скомпилируется
        Display displaySingleton = Display.INSTANCE;
        displaySingleton.draw("Hello world");
    }
}

