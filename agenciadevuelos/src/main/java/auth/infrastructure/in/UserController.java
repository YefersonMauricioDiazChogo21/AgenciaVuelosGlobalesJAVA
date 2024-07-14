package auth.infrastructure.in;

import java.util.ArrayList;
import java.util.Scanner;
import auth.application.CreateUser;
import auth.domain.AuthUser;
import auth.infrastructure.out.AuthUserRepository;
import rol.application.GetAllRol;
import rol.domain.Rol;

public class UserController {
    private final CreateUser createUser;
    private final GetAllRol getAllRol;

    public UserController(CreateUser createUser,GetAllRol getAllRol) {
        this.createUser = createUser;
        this.getAllRol = getAllRol;
    }

    public void createUser() {
        try (Scanner scanner = new Scanner(System.in)) {
            AuthUser user = new AuthUser();

            System.out.println("Ingrese la cedula: ");
            int id = scanner.nextInt();
            scanner.nextLine(); 

            System.out.println("Ingrese el usuario:");
            String usuario = scanner.nextLine();

            System.out.println("Ingresa la contraseña: ");
            String contraseña = scanner.nextLine();

            ArrayList <Rol> listRol = getAllRol.execute();
            System.out.println("*-*- LISTA DE ROLES -*-*\n");
            listRol.forEach(e -> System.out.println("\n"+ e.getId() + ". "+ e.getNombre()));

            System.out.println("\nIngresa el rol: ");
            int rol = scanner.nextInt();

          
            boolean usuarioExistente = verificarUsuarioExistente(usuario);

            if (usuarioExistente) {
                System.out.println("Error: El usuario ya existe en el sistema.");
                
            } else {
                user.setId(id);
                user.setUsuario(usuario);
                user.setContraseña(contraseña);
                user.setRolId(rol);

                System.out.println("Usuario creado:");
                System.out.println("ID: " + user.getId());
                System.out.println("Usuario: " + user.getUsuario());
                System.out.println("Contraseña: " + user.getContraseña());
                System.out.println("Rol ID: " + user.getRolId());

                createUser.execute(user);
                System.out.println("Usuario creado exitosamente");
            }
        } catch (Exception e) {
            System.err.println("Error al crear el usuario: " + e.getMessage());
        }
    }

 
    private boolean verificarUsuarioExistente(String usuario) {
        return AuthUserRepository.existsByUsername(usuario);
    }
}
