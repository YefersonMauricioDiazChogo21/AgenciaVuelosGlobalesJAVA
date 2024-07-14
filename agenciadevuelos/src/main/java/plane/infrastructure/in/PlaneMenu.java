package plane.infrastructure.in;

import plane.application.CreatePlane;
import plane.domain.ServicePlane;
import plane.infrastructure.out.PlaneRepository;
import planeModel.application.GetAllModels;
import planeModel.domain.ServiceModel;
import planeModel.infrastructure.out.ModelRepository;
import planeStatus.application.GetAllStatus;
import planeStatus.domain.ServiceStatus;
import planeStatus.infrastructure.out.StatusRepository;

public class PlaneMenu {
    
    public void MenuAvion(){
        ServiceStatus sServiceStatus = new StatusRepository();
        GetAllStatus getAllStatus = new GetAllStatus(sServiceStatus);

        ServiceModel serviceModel = new ModelRepository();
        GetAllModels getAllModels = new GetAllModels(serviceModel);

        ServicePlane servicePlane = new PlaneRepository();
        CreatePlane createPlane = new CreatePlane(servicePlane);

        PlaneController planeController = new PlaneController(getAllStatus, getAllModels, createPlane);

        planeController.RegisterPlane();

    }
    
}
