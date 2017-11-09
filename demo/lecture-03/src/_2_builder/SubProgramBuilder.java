package _2_builder;

import java.util.ArrayList;
import java.util.List;

public class SubProgramBuilder {
    private static int defaultPort = 1234;
    private boolean withGui = false;
    private int port = defaultPort;
    private Object someParameter1 = new Object();
    private Object someParameter2 = new Object();
    private Object someParameter3 = new Object();
    private Object someParameter4 = new Object();

    private List<String> keyBindings = new ArrayList<>();
    private List<String> ignoredKeys = new ArrayList<>();


    public SubProgramBuilder withGui(boolean isWithGui) {
        withGui = isWithGui;
        return this;
    }

    public SubProgramBuilder port(int specifiedPort) {
        port = specifiedPort;
        return this;
    }

    public SubProgramBuilder responseToKey(String key) {
        keyBindings.add(key);
        return this;
    }

    public SubProgramBuilder parameter1(Object obj) {
        someParameter1 = obj;
        return this;
    }

    public SubProgramBuilder parameter2(Object obj) {
        someParameter2 = obj;
        return this;
    }

    public SubProgramBuilder parameter3(Object obj) {
        someParameter3 = obj;
        return this;
    }

    public SubProgramBuilder parameter4(Object obj) {
        someParameter1 = obj;
        return this;
    }

    public SubProgram build() {
        return new SubProgram(
                withGui,
                port,
                new KeyProcessor(keyBindings, ignoredKeys),
                someParameter1,
                someParameter2,
                someParameter3,
                someParameter4
        );
    }
}
