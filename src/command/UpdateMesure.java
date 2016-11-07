package command;

import controller.Controller;

/**
 * Created by florian on 07/11/16.
 */
public class UpdateMesure implements Command {

	private Controller controller;

	public UpdateMesure(Controller controller) {
		this.controller = controller;
	}

	@Override
	public void execute() {
		controller.updateMesure();
	}
}
