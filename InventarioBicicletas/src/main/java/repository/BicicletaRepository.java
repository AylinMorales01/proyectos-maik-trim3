package repository;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.Conexion;
import model.Bicicleta;

public class BicicletaRepository {
    public void insertarBicicleta (Bicicleta bicicleta) {
        String sql = "INSERT INTO bicicletas (marca, color, precio) VALUES (?, ?, ?)";

        try (Connection connection = Conexion.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {


            preparedStatement.setString(1, bicicleta.getMarca());
            preparedStatement.setString(2, bicicleta.getColor());
            preparedStatement.setDouble(3, bicicleta.getPrecio());


            preparedStatement.executeUpdate();

            System.out.println("Bicicleta insertada correctamente.");

            } catch (Exception e) {
                e.printStackTrace();
        }
    }

    public List <Bicicleta> listarBicicletas() {
        List <Bicicleta> bicicletas = new ArrayList<>();
        String sql = "SELECT * FROM bicicletas";

        try (Connection connection = Conexion.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)) {
                
            while (resultSet.next()) {
                bicicletas.add(new Bicicleta(
                    resultSet.getLong("id"),
                    resultSet.getString("marca"),
                    resultSet.getString("color"),
                    resultSet.getDouble("precio")));
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return bicicletas;
    }

    public Bicicleta consultarBicicletaPorId(int idBicicleta) {
        String sql = "SELECT * FROM bicicletas WHERE id = ?";

        try (Connection connection = Conexion.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, idBicicleta);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Bicicleta bicicleta = new Bicicleta(
                    resultSet.getLong("id"),
                    resultSet.getString("marca"),
                    resultSet.getString("color"),
                    resultSet.getDouble("precio")
                );
                return bicicleta;
            } else {
                System.out.println("No se encontró un usuario con el ID proporcionado.");
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

        public boolean eliminarBicicletaPorId(Long id) {
    String sql = "DELETE FROM bicicletas WHERE id = ?";
    boolean eliminado = false;

    try (Connection conn = Conexion.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setLong(1, id);

        int filasAfectadas = stmt.executeUpdate();

        if (filasAfectadas > 0) {
            System.out.println("Bicicleta eliminada correctamente.");
            eliminado = true;
        } else {
            System.out.println("No se encontró ninguna bicicleta con ese ID.");
        }

    } catch (SQLException e) {
        System.out.println("Error al eliminar bicicleta: " + e.getMessage());
    }

    return eliminado;
    }

    public boolean actualizarBicicleta(Bicicleta bicicleta) {
    String sql = "UPDATE bicicletas SET marca = ?, color = ?, precio = ? WHERE id = ?";
    boolean actualizado = false;

    try (Connection conn = Conexion.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        // Asignar los valores al PreparedStatement
        stmt.setString(1, bicicleta.getMarca());
        stmt.setString(2, bicicleta.getColor());
        stmt.setDouble(3, bicicleta.getPrecio());
        stmt.setLong(4, bicicleta.getId());

        int filasAfectadas = stmt.executeUpdate();

        if (filasAfectadas > 0) {
            System.out.println("Bicicleta actualizada correctamente.");
            actualizado = true;
        } else {
            System.out.println("No se encontró ninguna bicicleta con ese ID.");
        }

    } catch (SQLException e) {
        System.out.println("Error al actualizar la bicicleta: " + e.getMessage());
    }

    return actualizado;
}

}