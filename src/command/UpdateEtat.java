package command;

import controller.Controller;

/**
 * Created by florian on 07/11/16.
 */
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
