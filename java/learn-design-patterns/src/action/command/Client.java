package action.command;

public class Client {

    public static void main(String[] args) {
        LightReceiver lightReceiver = new LightReceiver();
        LightOnCommand lightOnCommand = new LightOnCommand(lightReceiver);

        LightOffCommand lightOffCommand = new LightOffCommand(lightReceiver);
        RemoteController remoteController = new RemoteController();
        remoteController.setCommand(0, lightOnCommand, lightOffCommand);

        remoteController.onButtonPushed(0);
        remoteController.undoButtonPushed();
        System.out.println("--------------------");
        remoteController.offButtonPushed(0);
        remoteController.undoButtonPushed();
    }

}
