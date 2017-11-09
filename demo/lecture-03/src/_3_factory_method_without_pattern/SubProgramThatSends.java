package _3_factory_method_without_pattern;


import _3_factory_method_without_pattern.protocol.HttpProtocol;
import _3_factory_method_without_pattern.message.MessageSender;
import _3_factory_method_without_pattern.protocol.Pop3Protocol;

public class SubProgramThatSends {

    MessageSender sender;

    public SubProgramThatSends(HttpProtocol protocol) {
        this.sender = protocol.createHttpMessageSender();
    }

    public SubProgramThatSends(Pop3Protocol protocol)    {
        this.sender = protocol.createPop3MessageSender();
    }

    /*
    public SubProgramThatSends(YetAnotherProtocolA protocol) {
        this.sender = protocol.createAnotherMessageSenderA();
    }
    public SubProgramThatSends(YetAnotherProtocolB protocol) {
        this.sender = protocol.createAnotherMessageSenderB();
    }
    */

    public void run(){
        sender.send("hello");
        sender.send("good bye");
    }

}
