package secret.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum RoleSecret {
    ORDRE_DU_PHENIX(Alegeance.ORDRE_DU_PHOENIX),
    MANGE_MORT(Alegeance.MANGE_MORT),
    VOLDEMORT(Alegeance.MANGE_MORT);

    private final Alegeance alegeance;
}
