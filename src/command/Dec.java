package command;

import controller.Controller;

/**
 * Created by tp15009314 on 09/11/16.
 */
public class Dec implements  Command {

    private Controller controller;

    public Dec(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void execute() {
        controller.decMesure();
    }
}
