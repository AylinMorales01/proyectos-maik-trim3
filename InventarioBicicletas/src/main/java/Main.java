import java.util.Scanner;

import model.Bicicleta;
import repository.BicicletaRepository;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BicicletaRepository repo = new BicicletaRepository();

        System.out.println("Bienvenido al sistema de inventario de bicicletas");
        System.out.println("¿Cuál es tu rol?");
        System.out.println("1. Administrador");
        System.out.println("2. Usuario");

        int rol = scanner.nextInt();
        scanner.nextLine(); // limpiar buffer

        boolean salir = false;

        while (!salir) {
            if (rol == 1) {
                System.out.println("\n--- Menú Administrador ---");
                System.out.println("1. Insertar bicicleta");
                System.out.println("2. Listar bicicletas");
                System.out.println("3. Consultar bicicleta por ID");
                System.out.println("4. Actualizar bicicleta");
                System.out.println("5. Eliminar bicicleta");
                System.out.println("0. Salir");
                System.out.print("Seleccione una opción: ");
                int opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.print("Marca: ");
                        String marca = scanner.nextLine();
                        System.out.print("Color: ");
                        String color = scanner.nextLine();
                        System.out.print("Precio: ");
                        Double precio = scanner.nextDouble();
                        scanner.nextLine();
                        repo.insertarBicicleta(new Bicicleta(marca, color, precio));
                        break;

                    case 2:
                        System.out.println("\n--- Lista de bicicletas ---");
                        for (Bicicleta b : repo.listarBicicletas()) {
                            System.out.println("Id: " + b.getId() + " Marca: " + b.getMarca() +
                                               " Color: " + b.getColor() + " Precio: " + b.getPrecio());
                        }
                        break;

                    case 3:
                        System.out.print("Ingrese ID: ");
                        int idConsulta = scanner.nextInt();
                        Bicicleta bici = repo.consultarBicicletaPorId(idConsulta);
                        if (bici != null) {
                            System.out.println("Id: " + bici.getId() + " Marca: " + bici.getMarca() +
                                               " Color: " + bici.getColor() + " Precio: " + bici.getPrecio());
                        } else {
                            System.out.println("No se encontró la bicicleta.");
                        }
                        break;

                    case 4:
                        System.out.print("ID a actualizar: ");
                        Long idAct = scanner.nextLong();
                        scanner.nextLine();
                        System.out.print("Nueva marca: ");
                        String nuevaMarca = scanner.nextLine();
                        System.out.print("Nuevo color: ");
                        String nuevoColor = scanner.nextLine();
                        System.out.print("Nuevo precio: ");
                        Double nuevoPrecio = scanner.nextDouble();
                        scanner.nextLine();
                        repo.actualizarBicicleta(new Bicicleta(idAct, nuevaMarca, nuevoColor, nuevoPrecio));
                        break;

                    case 5:
                        System.out.print("ID a eliminar: ");
                        Long idEliminar = scanner.nextLong();
                        repo.eliminarBicicletaPorId(idEliminar);
                        break;

                    case 0:
                        salir = true;
                        break;

                    default:
                        System.out.println("Opción inválida.");
                }

            } else if (rol == 2) {
                System.out.println("\n--- Menú Usuario ---");
                System.out.println("1. Registrar venta de bicicleta");
                System.out.println("0. Salir");
                System.out.print("Seleccione una opción: ");
                int opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese ID de la bicicleta vendida: ");
                        Long idVenta = scanner.nextLong();
                        boolean vendida = repo.eliminarBicicletaPorId(idVenta);
                        if (vendida) {
                            System.out.println("Venta registrada. Bicicleta eliminada del inventario.");
                        } else {
                            System.out.println("No se pudo registrar la venta. Verifique el ID.");
                        }
                        break;

                    case 0:
                        salir = true;
                        break;

                    default:
                        System.out.println("Opción inválida.");
                }

            } else {
                System.out.println("Rol inválido. Reinicie el programa.");
                salir = true;
            }
        }

        scanner.close();
        System.out.println("Gracias por usar el sistema.");
    }
}
