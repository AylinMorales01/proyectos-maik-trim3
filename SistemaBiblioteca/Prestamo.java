import java.time.LocalDate;

public class Prestamo {
    private Libro libro;
    private Usuario usuario;
    private LocalDate fechaInicio;
    private LocalDate fechaLimite;
    private LocalDate fechaDevolucion;
    private long multa;

    public Prestamo(Libro libro, Usuario usuario, LocalDate fechaInicio, LocalDate fechaLimite) {
        this.libro = libro;
        this.usuario = usuario;
        this.fechaInicio = fechaInicio;
        this.fechaLimite = fechaLimite;
        this.fechaDevolucion = null;
        this.multa = 0;
    }

    public Libro getLibro() { return libro; }
    public Usuario getUsuario() { return usuario; }
    public LocalDate getFechaLimite() { return fechaLimite; }
    public LocalDate getFechaDevolucion() { return fechaDevolucion; }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public void setMulta(long multa) {
        this.multa = multa;
    }

    @Override
    public String toString() {
        String estado = (fechaDevolucion == null) 
            ? "En curso (límite " + fechaLimite + ")"
            : "Devuelto el " + fechaDevolucion + " | Multa: $" + multa;
        return "[Libro " + libro.getCodigo() + "] -> Usuario " + usuario.getDocumento() + " | Inicio: " + fechaInicio + " | " + estado;
    }
}
