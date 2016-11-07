package model;

import command.Command;

public interface Moteur {
    void setCommand(Command c, CommandName evt);

    boolean getEtat();
    int getTempo();
    int getMesure();

    void setEtat(boolean etat);
    void setTempo(int tempo);
    void setMesure(int mesure);
}
