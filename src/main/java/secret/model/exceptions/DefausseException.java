package secret.model.exceptions;

public class DefausseException extends SecretMetierException{

    public DefausseException(String message){
        super("Erreur dans action Defausse : " + message);
    }
}
