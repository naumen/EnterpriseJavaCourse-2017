package _6_decorator.wrapper;

import _6_decorator.SubProgram;

public class LoggingWrapper implements SubProgram {
    SubProgram wrappedSubProgram;
    public LoggingWrapper(SubProgram object) {
        this.wrappedSubProgram = object;
    }

    @Override
    public void run() {
        logStart();
        wrappedSubProgram.run();
        logEnd();
    }

    private void logStart() {}
    private void logEnd() {}
}
