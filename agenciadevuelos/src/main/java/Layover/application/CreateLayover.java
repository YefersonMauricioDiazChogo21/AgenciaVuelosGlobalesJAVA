package Layover.application;

import Layover.domain.Layover;
import Layover.domain.ServiceLayover;

public class CreateLayover {
private ServiceLayover serviceLayover;

public CreateLayover(ServiceLayover serviceLayover) {
    this.serviceLayover = serviceLayover;
}
 public void execute(Layover layover) {
        serviceLayover.CreateLayover(layover);
    }

}
