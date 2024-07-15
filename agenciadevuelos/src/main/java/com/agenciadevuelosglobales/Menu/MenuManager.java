package com.agenciadevuelosglobales.Menu;

import java.util.Scanner;

// import user.application.findUser.FindUser;
// import user.application.validation.ValidationUser;
// import user.domain.ServiceUser;
// import user.domain.User;
// import user.infrastructure.in.UserController;
 import user.infrastructure.in.UserMenu;
// import user.infrastructure.out.UserRepository;

public class MenuManager {
    private final Scanner scanner = new Scanner(System.in);

   
    public void startMainMenu() {
        try {
            while (true) {
                System.out.println("MENÚ PRINCIPAL");
                System.out.println("1. Iniciar sesión");
                System.out.println("2. Ingresar a AGENCIA DE VUELOS");
                System.out.println("3. Salir\n");

              
                    int choice = utils.Validation.leerNumero("Eliga la opcion: ", scanner);
                    

                    switch (choice) {
                        case 1:
                            UserMenu userMenu = new UserMenu();
                            userMenu.MenuUser();
                            
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
            
        } catch (Exception e) {
            System.err.println("Error en el menú principal: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
}
