package auth.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import auth.domain.AuthUser;
import auth.domain.ServiceAuthUser;
import config.DataBaseConfig;

public class AuthUserRepository implements ServiceAuthUser {


    public static boolean existsByUsername(String username) {
        String sql = "SELECT COUNT(*) FROM AutenticacionRol WHERE usuario = ?";
        try (Connection connection = DataBaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, username);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    @Override
    public void CreateUser(AuthUser authUser) {
        String sql = "INSERT INTO AutenticacionRol (id, usuario, contraseña, rolId) VALUES (?,?,?,?)";

        try (Connection connection = DataBaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            statement.setInt(1, authUser.getId());    
            statement.setString(2, authUser.getUsuario());
            statement.setString(3, authUser.getContraseña());
            statement.setInt(4, authUser.getRolId());

            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    authUser.setId(generatedKeys.getInt(1)); 
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
