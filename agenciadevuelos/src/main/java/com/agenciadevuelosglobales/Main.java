package com.agenciadevuelosglobales;

import com.agenciadevuelosglobales.Menu.MenuManager;

import rol.application.GetAllRol;
import rol.domain.ServiceRol;
import rol.infrastructure.out.RolRepository;
import user.application.createUser.CreateUser;
import user.application.findUser.FindUser;
import user.application.updateUser.UpdateUser;
import user.application.validation.ValidationUser;
import user.domain.ServiceUser;
import user.infrastructure.in.UserController;
import user.infrastructure.out.UserRepository;

public class Main {
    public static void main(String[] args) {
        ServiceUser serviceUser = new UserRepository();
        ServiceRol serviceRol = new RolRepository();
        GetAllRol getAllRol = new GetAllRol(serviceRol);
       CreateUser createUser = new CreateUser(serviceUser); 
       UpdateUser updateUser = new UpdateUser(serviceUser);
       ValidationUser validationUser = new ValidationUser(serviceUser);
       FindUser findUser = new FindUser(serviceUser);
       UserController userController = new UserController(createUser, getAllRol,findUser, updateUser);
       MenuManager menuManager = new MenuManager(userController);
        
        menuManager.startMainMenu();
    //    userController.createUser();

       
    }
}