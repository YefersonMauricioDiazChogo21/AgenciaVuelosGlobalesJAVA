package com.agenciadevuelosglobales.Menu;

import java.util.Scanner;
import user.infrastructure.in.UserController;

public class MenuManager {
    
    private final Scanner scanner = new Scanner(System.in);
    private final UserController userController; // Debes inicializar correctamente esta variable

    public MenuManager(UserController userController) {
        this.userController = userController;
    }

    public void startMainMenu(){
        
        while (true) {
            System.out.println("MENÚ PRINCIPAL");
            System.out.println("1. Iniciar sesión");
            System.out.println("2. Ingresar a AGENCIA DE VUELOS");
            System.out.println("3. Salir\n");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    userController.ValidationAccount();
                    break;
                case 2:
                    // Lógica para ingresar a la agencia de vuelos
                    System.out.println("Ingresando a la AGENCIA DE VUELOS...");
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    return; // Termina el método startMainMenu y la ejecución del programa
                default:
                    System.out.println("Opción no válida. Por favor, elige una opción válida.");
                    break;
            }
        }
    }
}
