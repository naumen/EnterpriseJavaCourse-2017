package _1_singleton;

public class BadSubProgram {

    public void doSomething(){
        Display displayDuplicate = new Display();
        displayDuplicate.draw("Hello world");
    }
}

