package plane.infrastructure.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import config.DataBaseConfig;
import plane.domain.Plane;
import plane.domain.ServicePlane;


public class PlaneRepository implements ServicePlane {

    @Override
    public void createPlane(Plane avion) {
        String sql = "INSERT INTO Avion(id,matricula,fechaFabricacion, Modelo_id,Estado_id) VALUES (?,?,?,?,?)";
        try (
            Connection connection = DataBaseConfig.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS)){
            statement.setString(1, avion.getMatricula());
            statement.setInt(2, avion.getCapacidad());
            statement.setDate(3,avion.getFechaFabricacion());
            statement.setInt(4,avion.getModeloId());
            statement.setInt(5,avion.getEstadoId());
            statement.executeUpdate();
            try(ResultSet generateKeys = statement.getGeneratedKeys()){;
                if(generateKeys.next()){
                    avion.setId(generateKeys.getInt(1));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
