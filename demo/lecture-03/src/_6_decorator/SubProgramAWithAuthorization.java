package _6_decorator;

public class SubProgramAWithAuthorization extends SubProgramA {

    @Override
    public void run() {
        checkRights();
        super.run();
    }

    private void checkRights(){};
}
