package vue;

import command.Command;
import command.UpdateEtat;
import javafx.scene.control.Slider;

/**
 * Created by tp15009314 on 09/11/16.
 */
public class Cursor extends Slider {

    Command updateCursor;
    public void UpdateCursor(){
        updateCursor.execute();
    }

    public void setUpdateCursor(Command updateCursor) {
        this.updateCursor = updateCursor;
    }
}
