package _3_factory_method_without_pattern;

import _3_factory_method_without_pattern.protocol.HttpProtocol;
import _3_factory_method_without_pattern.protocol.Pop3Protocol;

public class Main {

    public static void main(String[] args) {

        HttpProtocol httpProtocol = new HttpProtocol();
        new SubProgramThatSends(httpProtocol);

        Pop3Protocol pop3Protocol = new Pop3Protocol();
        new SubProgramThatSends(pop3Protocol);


    }

}
