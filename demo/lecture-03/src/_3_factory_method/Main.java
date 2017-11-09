package _3_factory_method;

import _3_factory_method.message.MessageSender;
import _3_factory_method.protocol.HttpProtocol;
import _3_factory_method.protocol.Pop3Protocol;
import _3_factory_method.protocol.ProtocolWithMessageSending;

public class Main {

    public static void main(String[] args) {

        ProtocolWithMessageSending protocol = chooseProtocol();

        new SubProgramThatSends(protocol);





        ProtocolWithMessageSending abstractFactoryForProtocol = new Pop3Protocol();

        // допустим эти 2 подпрограммы взаимодействуют между собой
        // и нужно чтобы отсылаемое сообщение было предобработано в соответствии с протоколом
        // такое согласование обеспечивается абстрактной фабрикой
        new SubProgramThatPrepareMessage(abstractFactoryForProtocol);
        new SubProgramThatSends(abstractFactoryForProtocol);

    }

    private static ProtocolWithMessageSending chooseProtocol(){
        if(System.currentTimeMillis() % 5 == 0)
            return new HttpProtocol();
        else if (System.currentTimeMillis() % 4 == 0)
            return new Pop3Protocol();

        else return new ProtocolWithMessageSending(){
                @Override
                public MessageSender createMessageSender() {
                    return null;
                }
            };
        // return new YetAnotherProtocol();
    }

}
