package com.agenciadevuelosglobales;



import java.util.ArrayList;

import auth.application.CreateUser;
import auth.domain.ServiceAuthUser;
import auth.infrastructure.in.UserController;
import auth.infrastructure.out.AuthUserRepository;
import rol.application.GetAllRol;
import rol.domain.Rol;
import rol.domain.ServiceRol;
import rol.infrastructure.out.RolRepository;

public class Main {
    public static void main(String[] args) {
        ServiceAuthUser serviceAuthUser = new AuthUserRepository();
        ServiceRol serviceRol = new RolRepository();
        GetAllRol getAllRol = new GetAllRol(serviceRol);
       CreateUser createUser = new CreateUser(serviceAuthUser); 
       UserController userController = new UserController(createUser, getAllRol);
       
        

       userController.createUser();

       
    }
}