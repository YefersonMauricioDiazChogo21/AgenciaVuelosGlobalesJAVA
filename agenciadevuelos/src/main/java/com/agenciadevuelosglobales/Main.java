package com.agenciadevuelosglobales;

import auth.application.CreateUser;
import auth.domain.ServiceAuthUser;
import auth.infrastructure.in.UserController;
import auth.infrastructure.out.AuthUserRepository;

public class Main {
    public static void main(String[] args) {
        ServiceAuthUser serviceAuthUser = new AuthUserRepository();
       CreateUser createUser = new CreateUser(serviceAuthUser);
       UserController userController = new UserController(createUser);
       
       userController.createUser();
    }
}