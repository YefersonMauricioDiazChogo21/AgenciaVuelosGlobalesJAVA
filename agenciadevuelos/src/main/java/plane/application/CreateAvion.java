package plane.application;

import plane.domain.Avion;
import plane.domain.ServiceAvion;

public class CreateAvion {
private final ServiceAvion serviceAvion;

public CreateAvion(ServiceAvion serviceAvion) {
    this.serviceAvion = serviceAvion;
}
public void execute(Avion avion){
        serviceAvion.CreateAvion(avion);
    }

}
