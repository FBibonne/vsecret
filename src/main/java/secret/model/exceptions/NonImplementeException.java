package secret.model.exceptions;

import secret.model.Partie;

public class NonImplementeException extends SecretTechniqueException {
    private final String monMessage;

    public NonImplementeException(){
        super();
        StackTraceElement stackTraceElement = super.getStackTrace()[0];
        monMessage = stackTraceElement.getClassName()+"."+stackTraceElement.getMethodName()+" pas encore implementee";
    }

    @Override
    public String getMessage() {
        return monMessage;
    }
}
