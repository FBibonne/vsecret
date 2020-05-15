package secret.services;

import secret.model.PileProclamations;

public interface PileProclamationsServices {
    /**
     * Retourne la pile de proclamations de la partie en cours
     * @return
     */
    PileProclamations findPileProclamations();
}
