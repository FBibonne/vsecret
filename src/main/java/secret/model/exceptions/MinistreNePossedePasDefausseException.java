package secret.model.exceptions;

import lombok.NonNull;
import secret.model.Proclamation;

public class MinistreNePossedePasDefausseException extends SecretMetierException {
    public MinistreNePossedePasDefausseException(@NonNull Proclamation proclamation) {
        super("Le ministre élu ne possède pas de "+proclamation+" dans sa main");
    }
}
