package plane.infrastructure.in;

import java.util.ArrayList;
import java.util.Scanner;

import plane.application.CreatePlane;
import plane.domain.Plane;
import planeModel.application.GetAllModels;
import planeModel.domain.Model;
import planeStatus.application.GetAllStatus;
import planeStatus.domain.Status;

public class PlaneController{
    private final GetAllStatus getAllStatus;
    private final CreatePlane createPlane;
    private final GetAllModels getAllModels;
    private final Scanner scanner = new Scanner(System.in);

    public PlaneController(GetAllStatus getAllStatus, GetAllModels getAllModels, CreatePlane createPlane) {
        this.getAllStatus = getAllStatus;
        this.createPlane = createPlane;
        this.getAllModels = getAllModels;
    }



    public void RegisterPlane(){
        Plane avion = new Plane();
        System.out.print("Digite la matricula del avion: ");
        avion.setMatricula(scanner.nextLine());
        System.out.print("Digite la capacidad del avion: ");
        avion.setCapacidad(scanner.nextInt());
        // System.out.println("Digite el id la fecha de Fabricacion: ");
        // avion.setFechaFabricacion(Date.valueOf(scanner.nextLine()));
        ArrayList<Status> listaEstados  = getAllStatus.execute();
        listaEstados.forEach((e) -> System.out.println("id: " + e.getId() + " Nombre: " + e.getName()));
        System.out.print("Digite el codigo del Status: ");
        Integer idStatus = scanner.nextInt();
        Boolean a = listaEstados.stream().anyMatch((e) -> e.getId()==idStatus);
        if(!a){
            System.out.println("Error id Invalido");
            return;
        }
        avion.setEstadoId(idStatus);

        ArrayList<Model> listaModelos  = getAllModels.execute();


    }   
        
}

