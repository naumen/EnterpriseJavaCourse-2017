package _3_factory_method.protocol;

import _3_factory_method.message.HttpMessageSender;
import _3_factory_method.message.MessageSender;
import _3_factory_method.message.Pop3MessageSender;

public class Pop3Protocol extends ProtocolWithMessageSending {

    // не забываем что делает много полезного

    @Override
    public MessageSender createMessageSender(){
        return new Pop3MessageSender();
    }

}
