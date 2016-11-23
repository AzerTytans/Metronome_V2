package command;

import controller.Controller;


public class UpdateEtat implements  Command {

	private Controller controller;

	public UpdateEtat(Controller controller) {
		this.controller = controller;
	}

	@Override
	public void execute() {
		controller.updateEtat();
	}
}
