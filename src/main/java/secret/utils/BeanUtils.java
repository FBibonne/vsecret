package secret.utils;

import lombok.NonNull;
import secret.model.exceptions.NbJoueursIncorrectsException;

import java.util.function.Consumer;

public class BeanUtils {

    /**
     * Méthode qui répète n fois la méthode consumer sur instance et qui retourne instance ainsi modifiée
     * @param instance
     * @param consumer
     * @param n
     * @param <T>
     * @return
     */
    public static <T> T  repeat(@NonNull T instance, @NonNull Consumer<T> consumer ,int n){
        for (int i = 1; i <=n ; i++) {
            consumer.accept(instance);
        }
        return instance;
    }
}
