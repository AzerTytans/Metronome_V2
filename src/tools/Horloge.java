package tools;

import command.Command;

/**
 * Created by ce on 09/11/16.
 */
public interface Horloge {
    void activerPeriodiquement(Command cmd, float delay);
    void activerApresDelai(Command cmd, float delay);
    void desactiver();
}
