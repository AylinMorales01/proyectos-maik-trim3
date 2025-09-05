import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner sc = new Scanner(System.in);

        // Datos de prueba
        biblioteca.registrarLibro("Cien años de soledad", "Gabriel García Márquez", "0001");
        biblioteca.registrarUsuario("Aylin", "Chaverra", "aylin.morales2401@gmail.com", 1097394968);

        int opcion;
        do {
            System.out.println("\n=== Menú Biblioteca ===");
            System.out.println("1. Registrar libro");
            System.out.println("2. Registrar usuario");
            System.out.println("3. Prestar libro");
            System.out.println("4. Devolver libro");
            System.out.println("5. Mostrar libros disponibles");
            System.out.println("6. Mostrar usuarios");
            System.out.println("7. Mostrar historial préstamos");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Título: ");
                    String titulo = sc.nextLine();
                    System.out.print("Autor: ");
                    String autor = sc.nextLine();
                    System.out.print("Código: ");
                    String codigo = sc.nextLine();
                    biblioteca.registrarLibro(titulo, autor, codigo);
                    break;
                case 2:
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Documento Usuario: ");
                    Integer idU = sc.nextInt();
                    sc.nextLine();
                    biblioteca.registrarUsuario(nombre, apellido, email, idU);
                    break;
                case 3:
                    System.out.print("Código libro: ");
                    String codL = sc.nextLine();
                    System.out.print("Documento del usuario: ");
                    Integer idUs = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Días préstamo: ");
                    int dias = sc.nextInt();
                    sc.nextLine();
                    biblioteca.prestarLibro(codL, idUs, dias);
                    break;
                case 4:
                    System.out.print("Código libro: ");
                    String codDev = sc.nextLine();
                    System.out.print("Documento del usuario: ");
                    Integer idDev = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Fecha devolución (YYYY-MM-DD): ");
                    String fechaStr = sc.nextLine();
                    LocalDate fechaDev = LocalDate.parse(fechaStr);
                    biblioteca.devolverLibro(codDev, idDev, fechaDev);
                    break;
                case 5:
                    biblioteca.mostrarLibrosDisponibles();
                    break;
                case 6:
                    biblioteca.mostrarUsuarios();
                    break;
                case 7:
                    biblioteca.mostrarHistorialPrestamos();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);

        sc.close();
    }
}
