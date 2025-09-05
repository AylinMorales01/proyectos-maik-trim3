import java.util.ArrayList;
import java.util.List;

public class Usuario {
    String nombre;
    String apellido;
    String email;
    Integer documento;
    List<Libro> librosPrestados;

    public Usuario(String nombre, String apellido, String email, Integer documento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.documento = documento;
        this.librosPrestados = new ArrayList<>();
    }

    public void mostrarDatos() {
        System.out.println("(" + documento + ") " + nombre + 
                           " | Libros prestados: " + librosPrestados.size());
    }

    public boolean agregarPrestamo(Libro libro) {
        if (librosPrestados.size() >= 3) {
            System.out.println("El usuario ya tiene el máximo de 3 libros.");
            return false;
        }
        librosPrestados.add(libro);
        return true;
    }

    public boolean devolverLibro(Libro libro) {
        return librosPrestados.remove(libro);
    }

    public Integer getDocumento() {
        return documento;
    }
}
