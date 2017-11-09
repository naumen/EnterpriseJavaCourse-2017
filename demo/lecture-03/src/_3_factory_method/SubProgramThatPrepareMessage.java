package _3_factory_method;

import _3_factory_method.message.MessageProcessor;
import _3_factory_method.message.MessageProcessor;
import _3_factory_method.protocol.ProtocolWithMessageSending;

public class SubProgramThatPrepareMessage {

    MessageProcessor processor;

    public SubProgramThatPrepareMessage(ProtocolWithMessageSending protocol) {
        this.processor = protocol.createMessageProcessor();
    }

    public void run(){

    }

}
