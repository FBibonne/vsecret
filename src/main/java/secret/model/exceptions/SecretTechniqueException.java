package secret.model.exceptions;

public class SecretTechniqueException extends RuntimeException{

    public SecretTechniqueException(){
        super();
    }

    public SecretTechniqueException(String message){
        super(message);
    }
}
