package _6_decorator;

import _6_decorator.wrapper.AuthorizationWrapper;
import _6_decorator.wrapper.LoggingWrapper;
import _6_decorator.wrapper.NotificationWrapper;

public class Application {

    boolean isAuthorizationNeeded = false;
    boolean isLoggingEnabled = true;

    public void run(){

        SubProgram subProgram = new SubProgramA();

        SubProgram wrappedSubprogram1 = new LoggingWrapper(
                new NotificationWrapper(
                        new AuthorizationWrapper(
                                subProgram
                        )
                )
        );



        boolean isAuthorizationNeeded = false;
        boolean isLoggingEnabled = true;


        SubProgram subProgramDynamic = new SubProgramA();

        // динамически
        if(isAuthorizationNeeded){
            subProgramDynamic = new AuthorizationWrapper(subProgramDynamic);
        }
        if(isLoggingEnabled){
            subProgramDynamic = new LoggingWrapper(subProgramDynamic);
        }

        subProgramDynamic.run();
    }
}
