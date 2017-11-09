package _6_decorator.wrapper;

import _6_decorator.SubProgram;

public class AuthorizationWrapper implements SubProgram {

    SubProgram wrappedSubProgram;

    public AuthorizationWrapper(SubProgram object) {
        this.wrappedSubProgram = object;
    }

    @Override
    public void run() {
        checkRights();
        wrappedSubProgram.run();
    }

    private void checkRights(){};
}
