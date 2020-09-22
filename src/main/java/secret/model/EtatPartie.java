package secret.model;

public enum EtatPartie {
    INITIALISATION /* joueurs en cours d'inscription*/,
    EN_COURS /*inscription des joueurs terminés et rôles distribués : JoueurApi.listerRoles est accessible*/
}
