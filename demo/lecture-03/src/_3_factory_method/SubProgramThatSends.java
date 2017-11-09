package _3_factory_method;

import _3_factory_method.message.MessageSender;
import _3_factory_method.protocol.ProtocolWithMessageSending;

public class SubProgramThatSends {

    MessageSender sender;

    public SubProgramThatSends(ProtocolWithMessageSending protocol) {
        this.sender = protocol.createMessageSender();
    }

    public void run(){
        sender.send("hello");
        sender.send("good bye");
    }

}
