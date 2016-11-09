package command;

import controller.Controller;

/**
 * Created by tp15009314 on 09/11/16.
 */
public class Start implements  Command {

    private Controller controller;

    public Start(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void execute() {
        controller.start();
    }
}
