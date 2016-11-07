package command;

import controller.Controller;

public class MarquerMesure implements Command{
    private Controller controller;

    public MarquerMesure(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void execute() {
        this.controller.marquerMesure();
    }
}