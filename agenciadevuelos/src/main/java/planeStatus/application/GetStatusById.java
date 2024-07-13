package planeStatus.application;

import planeStatus.domain.ServiceStatus;

public class GetStatusById {
    public final ServiceStatus serviceStatus;

    public  GetStatusById(ServiceStatus serviceStatus) {
        this.serviceStatus = serviceStatus;
    }

    public void execute(Integer id){
        serviceStatus.getStatusById(id);
    } 
}
