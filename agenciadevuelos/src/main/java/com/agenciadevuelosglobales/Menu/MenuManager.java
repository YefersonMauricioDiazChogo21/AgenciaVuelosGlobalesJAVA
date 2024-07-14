package com.agenciadevuelosglobales.Menu;

import java.util.Scanner;

import plane.infrastructure.in.PlaneMenu;

public class MenuManager {
    
    private final Scanner scanner = new Scanner(System.in);

    public void startMainMenu(){
        PlaneMenu planeMenu = new PlaneMenu();
        planeMenu.MenuAvion();


    }
}
