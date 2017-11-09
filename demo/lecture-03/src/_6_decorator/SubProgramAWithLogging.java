package _6_decorator;

public class SubProgramAWithLogging extends SubProgramA {

    @Override
    public void run() {
        logStart();
        super.run();
        logEnd();
    }

    private void logStart(){}
    private void logEnd(){}
}
