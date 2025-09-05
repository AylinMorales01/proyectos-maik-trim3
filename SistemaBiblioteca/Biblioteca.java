import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Libro> libros;
    private List<Usuario> usuarios;
    private List<Prestamo> prestamos;

    public Biblioteca() {
        libros = new ArrayList<>();
        usuarios = new ArrayList<>();
        prestamos = new ArrayList<>();
    }

    public void registrarLibro(String titulo, String autor, String codigo) {
        for (Libro l : libros) {
            if (l.getCodigo().equals(codigo)) {
                System.out.println("Ya existe un libro con ese código.");
                return;
            }
        }
        libros.add(new Libro(titulo, autor, codigo));
        System.out.println("Libro registrado.");
    }

    public void registrarUsuario(String nombre, String apellido, String email, Integer documento) {
        for (Usuario u : usuarios) {
            if (u.getDocumento().equals(documento)) {
                System.out.println("Ya existe un usuario con ese documento.");
                return;
            }
        }
        // CORREGIDO: usar variables reales y constructor sin teléfono
        usuarios.add(new Usuario(nombre, apellido, email, documento));
        System.out.println("Usuario registrado.");
    }

    public void prestarLibro(String codigoLibro, Integer documento, int dias) {
        Libro libro = buscarLibro(codigoLibro);
        // CORREGIDO: buscar por documento (Integer), no por el literal "documento"
        Usuario usuario = buscarUsuario(documento);

        if (libro == null) {
            System.out.println("Libro no encontrado.");
            return;
        }
        if (usuario == null) {
            System.out.println("Usuario no encontrado.");
            return;
        }
        if (!libro.isDisponible()) {
            System.out.println("El libro no está disponible.");
            return;
        }
        if (!usuario.agregarPrestamo(libro)) {
            return; // Ya tiene 3 libros
        }

        libro.marcarPrestado();
        LocalDate inicio = LocalDate.now();
        LocalDate limite = inicio.plusDays(dias);

        prestamos.add(new Prestamo(libro, usuario, inicio, limite));
        System.out.println("Préstamo registrado. Fecha límite: " + limite);
    }

    public void devolverLibro(String codigoLibro, Integer documento, LocalDate fechaDevolucion) {
        Libro libro = buscarLibro(codigoLibro);
        // CORREGIDO: buscar por documento (Integer), no por el literal "documento"
        Usuario usuario = buscarUsuario(documento);

        if (libro == null || usuario == null) {
            System.out.println("Libro o usuario no encontrado.");
            return;
        }

        Prestamo prestamo = null;
        for (Prestamo p : prestamos) {
            if (p.getLibro().equals(libro) && p.getUsuario().equals(usuario) && p.getFechaDevolucion() == null) {
                prestamo = p;
                break;
            }
        }

        if (prestamo == null) {
            System.out.println("No se encontró un préstamo activo.");
            return;
        }

        libro.marcarDisponible();
        usuario.devolverLibro(libro);
        prestamo.setFechaDevolucion(fechaDevolucion);

        long retraso = ChronoUnit.DAYS.between(prestamo.getFechaLimite(), fechaDevolucion);
        if (retraso > 0) {
            long multa = retraso * 500;
            prestamo.setMulta(multa);
            System.out.println("Devolución registrada con multa de $" + multa);
        } else {
            System.out.println("Devolución registrada sin multa.");
        }
    }

    public void mostrarLibrosDisponibles() {
        for (Libro l : libros) {
            if (l.isDisponible()) {
                l.mostrarDatos();
            }
        }
    }

    public void mostrarUsuarios() {
        for (Usuario u : usuarios) {
            u.mostrarDatos();
        }
    }

    public void mostrarHistorialPrestamos() {
        for (Prestamo p : prestamos) {
            System.out.println(p);
        }
    }

    private Libro buscarLibro(String codigo) {
        for (Libro l : libros) {
            if (l.getCodigo().equals(codigo)) return l;
        }
        return null;
    }

    // CORREGIDO: documento como Integer para comparar con Integer
    private Usuario buscarUsuario(Integer documento) {
        for (Usuario u : usuarios) {
            if (u.getDocumento().equals(documento)) return u;
        }
        return null;
    }
}
