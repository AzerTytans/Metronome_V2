package command;

import controller.Controller;

/**
 * Created by florian on 07/11/16.
 */
public class UpdateTempo implements Command {


	private Controller controller;

	public UpdateTempo(Controller controller) {
		this.controller = controller;
	}

	@Override
	public void execute() {
		controller.updateTempo();
	}
}
