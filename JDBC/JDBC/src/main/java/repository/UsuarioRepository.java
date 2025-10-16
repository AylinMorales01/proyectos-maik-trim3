package repository;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.Conexion;
import model.Usuario;


public class UsuarioRepository {
    public void insertarUsuario(Usuario usuario) {
        String sql = "INSERT INTO USUARIO (NOMBRE, EDAD) VALUES (?, ?)";

        try (Connection connection = Conexion.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, usuario.getNombre());
            preparedStatement.setLong(2, usuario.getEdad());


            preparedStatement.executeUpdate();

            System.out.println("Usuario insertado correctamente");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List <Usuario> listarUsuarios() { 
        List <Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM USUARIO";

        try (Connection connection = Conexion.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                usuarios.add(new Usuario(
                    resultSet.getLong("id"),
                    resultSet.getString("nombre"),
                    resultSet.getLong("edad")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    public Usuario consultarUsuarioPorId(int idUsuario) {
        String sql = "SELECT * FROM usuario WHERE id = ?";

        try (Connection connection = Conexion.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, idUsuario);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Usuario usuario = new Usuario(
                    resultSet.getLong("id"),
                    resultSet.getString("nombre"),
                    resultSet.getLong("edad")
                );
                return usuario;
            } else {
                System.out.println("No se encontró un usuario con el ID proporcionado.");
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean eliminarUsuarioPorId(Long id) {
    String sql = "DELETE FROM usuario WHERE id = ?";
    boolean eliminado = false;

    try (Connection conn = Conexion.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setLong(1, id);

        int filasAfectadas = stmt.executeUpdate();

        if (filasAfectadas > 0) {
            System.out.println("Usuario eliminado correctamente.");
            eliminado = true;
        } else {
            System.out.println("No se encontró ningún usuario");
        }

    } catch (SQLException e) {
        System.out.println("Error al eliminar usuario: " + e.getMessage());
    }

    return eliminado;
    }

    public boolean actualizarUsuario(Usuario usuario) {
    String sql = "UPDATE usuario SET nombre = ?, edad = ? WHERE id = ?";
    boolean actualizado = false;

    try (Connection conn = Conexion.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        // Asignar los valores al PreparedStatement
        stmt.setString(1, usuario.getNombre());
        stmt.setLong(2, usuario.getEdad());
        stmt.setLong(3, usuario.getId());

        int filasAfectadas = stmt.executeUpdate();

        if (filasAfectadas > 0) {
            System.out.println("Usuario actualizado correctamente.");
            actualizado = true;
        } else {
            System.out.println("No se encontró ningún usuario con ese ID.");
        }

    } catch (SQLException e) {
        System.out.println("Error al actualizar usuario: " + e.getMessage());
    }

    return actualizado;
}

}