package _6_decorator.wrapper;

import _6_decorator.SubProgram;

public class NotificationWrapper implements SubProgram {

    SubProgram wrappedSubProgram;

    public NotificationWrapper(SubProgram object) {
        this.wrappedSubProgram = object;
    }

    @Override
    public void run() {
        logStart();
        wrappedSubProgram.run();
        logEnd();
    }

    private void logStart(){}
    private void logEnd(){}
}
