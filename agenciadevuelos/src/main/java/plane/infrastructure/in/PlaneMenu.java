package plane.infrastructure.in;

import plane.application.CreatePlane;
import plane.application.DeletePlaneByPlate;
import plane.application.GetAllPlanes;
import plane.application.UpdatePlaneByPlate;
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
        GetAllPlanes getAllPlanes = new GetAllPlanes(servicePlane);
        DeletePlaneByPlate deletePlaneByPlate = new DeletePlaneByPlate(servicePlane);
        UpdatePlaneByPlate updatePlaneByPlate = new UpdatePlaneByPlate(servicePlane);


        PlaneController planeController = new PlaneController(updatePlaneByPlate, deletePlaneByPlate,getAllPlanes, getAllStatus, createPlane, getAllModels);

        
        planeController.updatePlaneByPlate();

    }
    
}
