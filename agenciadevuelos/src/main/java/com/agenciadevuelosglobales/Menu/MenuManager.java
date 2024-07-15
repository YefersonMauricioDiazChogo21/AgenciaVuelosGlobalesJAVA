package com.agenciadevuelosglobales.Menu;


import java.util.Scanner;

import plane.infrastructure.in.PlaneMenu;
import utils.Validation;

public class MenuManager {
    Scanner scanner = new Scanner(System.in);
    
    public void startMainMenu(){
        System.out.println("-Menus-");
        System.out.println("1. Menu Avion");
        
        int option = Validation.leerNumero("Digite la opcion: ", scanner);


        switch (option) {
            case 1:
                PlaneMenu planeMenu = new PlaneMenu();
                planeMenu.MenuAvion();
                
                break;
        
            default:
                break;
        }


    }
}
