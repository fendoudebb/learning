package action.command;

public class RemoteController {

    private Command[] onCommands;
    private Command[] offCommands;
    private Command undoCommand;

    public RemoteController() {
        onCommands = new Command[5];
        offCommands = new Command[5];
        for (int i = 0; i < 5; i++) {
            onCommands[i] = new NoCommand();
            offCommands[i] = new NoCommand();
        }
    }

    public void setCommand(int index, Command onCommand, Command offCommand) {
        this.onCommands[index] = onCommand;
        this.offCommands[index] = offCommand;
    }

    public void onButtonPushed(int index) {
        onCommands[index].execute();
        undoCommand = onCommands[index];
    }

    public void offButtonPushed(int index) {
        offCommands[index].execute();
        undoCommand = offCommands[index];
    }

    public void undoButtonPushed() {
        undoCommand.undo();
    }
}
