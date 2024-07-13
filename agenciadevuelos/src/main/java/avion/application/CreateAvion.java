package avion.application;

import avion.domain.Avion;
import avion.domain.ServiceAvion;

public class CreateAvion {
private final ServiceAvion serviceAvion;

public CreateAvion(ServiceAvion serviceAvion) {
    this.serviceAvion = serviceAvion;
}
public void execute(Avion avion){
        serviceAvion.CreateAvion(avion);
    }

}
