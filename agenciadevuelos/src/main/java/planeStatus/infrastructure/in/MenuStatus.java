package planeStatus.infrastructure.in;

import java.util.ArrayList;

import planeStatus.application.GetAllStatus;
import planeStatus.domain.Status;

public class MenuStatus {
    private final GetAllStatus getAllStatus;

    public MenuStatus(GetAllStatus getAllStatus) {
        this.getAllStatus = getAllStatus;
    }

    public void Start(){
        ArrayList<Status> estados = getAllStatus.execute();

        estados.forEach(e -> System.out.println(e.getName() + e.getId()));
        System.out.println(estados.get(0).getName());
    }
}
