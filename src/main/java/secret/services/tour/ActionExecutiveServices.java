package secret.services.tour;

import lombok.NonNull;
import secret.api.tour.ActionExecutiveApi;
import secret.model.Pouvoir;

public interface ActionExecutiveServices {


    public boolean verifierEndolorisJouable(@NonNull Pouvoir pouvoir, @NonNull ActionExecutiveApi actionExecutive);

    public boolean verifierAvadaKedavraJouable(@NonNull Pouvoir pouvoir, @NonNull ActionExecutiveApi actionExecutive);
}
