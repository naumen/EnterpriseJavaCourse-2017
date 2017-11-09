package _3_factory_method_without_pattern.protocol;

import _3_factory_method_without_pattern.message.Pop3MessageSender;

public class Pop3Protocol{

    public Pop3MessageSender createPop3MessageSender(){
        return new Pop3MessageSender();
    }

}
