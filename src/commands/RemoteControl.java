package commands;

public class RemoteControl {
    private Command lastCommand;

    public void pressButton(Command command) {
        command.execute();
        lastCommand = command;
    }

    public void pressUndo(){
        if(lastCommand != null){
            lastCommand.undo();
        }
    }
}
