package com.agenciadevuelosglobales;

import planeStatus.application.GetAllStatus;
import planeStatus.domain.ServiceStatus;
import planeStatus.infrastructure.in.MenuStatus;
import planeStatus.infrastructure.out.StatusRepository;

// import auth.application.CreateUser;
// import auth.domain.ServiceAuthUser;
// import auth.infrastructure.in.UserController;
// import auth.infrastructure.out.AuthUserRepository;

public class Main {
    public static void main(String[] args) {
    //     ServiceAuthUser serviceAuthUser = new AuthUserRepository();
    //    CreateUser createUser = new CreateUser(serviceAuthUser);
    //    UserController userController = new UserController(createUser);
       
    //    userController.createUser();

        ServiceStatus serviceStatus = new StatusRepository();
        GetAllStatus getAllStatus = new GetAllStatus(serviceStatus);
        MenuStatus menuStatus = new MenuStatus(getAllStatus);
        menuStatus.Start();
    }
}