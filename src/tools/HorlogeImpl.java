package tools;

import command.Command;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by ce on 09/11/16.
 */
public class HorlogeImpl implements Horloge{

    private Timer timer;

    public HorlogeImpl() {
        this.timer = new Timer(0, null);
        timer.stop();
    }

    @Override
    public void activerPeriodiquement(Command cmd, float delay) {
        this.timer.setDelay((int) delay);
        this.timer.addActionListener(new CommandListener(cmd, true));
        this.timer.start();
    }

    @Override
    public void activerApresDelai(Command cmd, float delay) {
        this.timer.setDelay((int) delay);
        this.timer.addActionListener(new CommandListener(cmd, false));
        this.timer.start();
    }

    @Override
    public void desactiver() {
        this.timer.stop();
        for(ActionListener a : this.timer.getActionListeners())
            this.timer.removeActionListener(a);
    }

    private class CommandListener implements ActionListener {
        private Command cmd;
        private boolean repeat;

        public CommandListener(Command cmd, boolean b) {
            this.cmd = cmd;
            this.repeat = b;
        }

        public void actionPerformed(ActionEvent e){
            this.cmd.execute();
            if(!repeat)
                timer.removeActionListener(this);
        }
    }
}
