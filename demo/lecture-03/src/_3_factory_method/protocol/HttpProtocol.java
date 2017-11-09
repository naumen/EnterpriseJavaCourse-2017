package _3_factory_method.protocol;

import _3_factory_method.message.HttpMessageSender;
import _3_factory_method.message.MessageSender;

public class HttpProtocol extends ProtocolWithMessageSending {

    @Override
    public MessageSender createMessageSender(){
        return new HttpMessageSender();
    }

}
