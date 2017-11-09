package _6_decorator;

public class SubProgramAWithAuthorizationWithLogging extends SubProgramAWithAuthorization {

    @Override
    public void run() {
        logStart();
        super.run();
        logEnd();
    }

    private void logStart(){}
    private void logEnd(){}
}
