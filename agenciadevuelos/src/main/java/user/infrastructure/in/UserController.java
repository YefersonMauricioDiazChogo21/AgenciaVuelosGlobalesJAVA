package user.infrastructure.in;

import java.util.ArrayList;
import java.util.Scanner;

import rol.application.GetAllRol;
import rol.domain.Rol;
import user.application.createUser.CreateUser;
import user.application.findUser.FindUser;
import user.application.updateUser.UpdateUser;
import user.domain.User;
import user.infrastructure.out.UserRepository;

public class UserController {
    private final CreateUser createUser;
    private final GetAllRol getAllRol;
    private final FindUser findUser;
    private final UpdateUser updateUser;

    public UserController(CreateUser createUser, GetAllRol getAllRol, FindUser findUser, UpdateUser updateUser) {
        this.createUser = createUser;
        this.getAllRol = getAllRol;
        this.findUser = findUser;
        this.updateUser = updateUser;
    }

    public void createUser() {
        try (Scanner scanner = new Scanner(System.in)) {
            User user = new User();

            System.out.println("Ingrese la cédula: ");
            int id = scanner.nextInt();
            scanner.nextLine(); 

            System.out.println("Ingrese el usuario:");
            String usuario = scanner.nextLine();

            System.out.println("Ingresa la contraseña: ");
            String contraseña = scanner.nextLine();

            ArrayList<Rol> listRol = getAllRol.execute();

            String leftAlignFormat = "| %-3d | %-20s |%n";
            System.out.format("+-----+----------------------+%n");
            System.out.format("| ID  | Nombre               |%n");
            System.out.format("+-----+----------------------+%n");
            for (Rol rol : listRol) {
                System.out.format(leftAlignFormat, rol.getId(), rol.getNombre());
            }
            System.out.format("+-----+----------------------+%n");

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

                createUser.execute(user);

                // Imprimir la información del usuario creado en formato tabla
                System.out.println("Usuario creado exitosamente:");
                String userTableFormat = "| %-15s | %-20s |%n";
                System.out.format("+-----------------+----------------------+%n");
                System.out.format("| Campo           | Valor                |%n");
                System.out.format("+-----------------+----------------------+%n");
                System.out.format(userTableFormat, "ID", user.getId());
                System.out.format(userTableFormat, "Usuario", user.getUsuario());
                System.out.format(userTableFormat, "Contraseña", user.getContraseña());
                System.out.format(userTableFormat, "Rol ID", user.getRolId());
                System.out.format("+-----------------+----------------------+%n");
            }
        } catch (Exception e) {
            System.err.println("Error al crear el usuario: " + e.getMessage());
        }
    }

    public void updateById() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Ingrese la cédula del usuario a actualizar:");
            int id = scanner.nextInt();
            scanner.nextLine(); 

            User user = findUser.execute(id);
            if (user != null) {
                System.out.println("Usuario encontrado:");
                System.out.println("ID: " + user.getId());
                System.out.println("Usuario: " + user.getUsuario());
                System.out.println("Rol ID: " + user.getRolId());

                System.out.println("¿Qué deseas modificar del usuario?");
                System.out.println("1. Usuario");
                System.out.println("2. Contraseña");
                System.out.println("3. Rol");
                int choice = scanner.nextInt();
                scanner.nextLine(); 

                User updatedUser = null;
                switch (choice) {
                    case 1:
                        System.out.println("Ingresa el nuevo usuario:");
                        String newUser = scanner.nextLine();
                        updatedUser = updateUser.execute(id, newUser, user.getContraseña(), user.getRolId());
                        if (updatedUser != null) {
                            System.out.println("Usuario actualizado a: " + updatedUser.getUsuario());
                        } else {
                            System.out.println("Error al actualizar el nombre.");
                        }
                        break;
                    case 2:
                        System.out.println("Ingresa la nueva contraseña:");
                        String newContraseña = scanner.nextLine();
                        updatedUser = updateUser.execute(id, user.getUsuario(), newContraseña, user.getRolId());
                        if (updatedUser != null) {
                            System.out.println("Contraseña actualizada a: " + updatedUser.getContraseña());
                        } else {
                            System.out.println("Error al actualizar la contraseña.");
                        }
                        break;
                    case 3:
                        ArrayList<Rol> listRol = getAllRol.execute();
                        String leftAlignFormat = "| %-3d | %-20s |%n";
                        System.out.format("+-----+----------------------+%n");
                        System.out.format("| ID  | Nombre               |%n");
                        System.out.format("+-----+----------------------+%n");
                        for (Rol rol : listRol) {
                            System.out.format(leftAlignFormat, rol.getId(), rol.getNombre());
                        }
                        System.out.format("+-----+----------------------+%n");

                        System.out.println("Ingresa el nuevo rol:");
                        int newRol = scanner.nextInt();
                        updatedUser = updateUser.execute(id, user.getUsuario(), user.getContraseña(), newRol);
                        if (updatedUser != null) {
                            System.out.println("Rol actualizado a: " + updatedUser.getRolId());
                        } else {
                            System.out.println("Error al actualizar el rol.");
                        }
                        break;
                    default:
                        System.out.println("Opción no válida.");
                        break;
                }
            } else {
                System.out.println("No se encontró ningún usuario con la cédula: " + id);
            }
        } catch (Exception e) {
            System.err.println("Error al actualizar el usuario: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void ValidationAccount() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Ingresa la cedula: ");
            int userId = scanner.nextInt();

            System.out.println("Ingresa la contraseña: ");
            char[] contraseña = System.console().readPassword(); 
            
            User user = findUser.execute(userId);


            if (user != null && user.getContraseña().equals(new String(contraseña))) {
                System.out.println("Ingreso exitoso");
            } else {
                System.out.println("Usuario o contraseña incorrectos");
            }
        } catch (Exception e) {
            System.err.println("Error al validar el usuario: " + e.getMessage());
        }
    }

    private boolean verificarUsuarioExistente(String usuario) {
        return UserRepository.existsByUsername(usuario);
    }
}
