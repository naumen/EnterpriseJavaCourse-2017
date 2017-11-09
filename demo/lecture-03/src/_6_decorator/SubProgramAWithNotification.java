package _6_decorator;

public class SubProgramAWithNotification extends SubProgramA {

    @Override
    public void run() {
        super.run();
        sendNotification();
    }
    private void sendNotification(){}
}
