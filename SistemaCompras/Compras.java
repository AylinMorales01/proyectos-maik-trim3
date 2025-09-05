import java.util.*;

public class Compras {
    static class Producto {
        String nombre;
        double precio;
        int stock;

        Producto(String nombre, double precio, int stock) {
            this.nombre = nombre;
            this.precio = precio;
            this.stock = stock;
        }
    }

    static class Cliente {
        String nombre;
        String apellido;
        String email;
        String telefono;

        Cliente(String nombre, String apellido, String email, String telefono) {
            this.nombre = nombre;
            this.apellido = apellido;
            this.email = email;
            this.telefono = telefono;
        }
    }

    static class Carrito {
        Map<Producto, Integer> productos = new HashMap<>();

        void agregarProducto(Producto p, int cantidad) {
            productos.put(p, productos.getOrDefault(p, 0) + cantidad);
        }

        double calcularTotal() {
            double total = 0;
            for (Map.Entry<Producto, Integer> entry : productos.entrySet()) {
                total += entry.getKey().precio * entry.getValue();
            }
            return total;
        }

        void mostrarCarrito() {
            System.out.println("Carrito:");
            for (Map.Entry<Producto, Integer> entry : productos.entrySet()) {
                System.out.println(entry.getKey().nombre + " x" + entry.getValue() + " = $" + (entry.getKey().precio * entry.getValue()));
            }
            System.out.println("Total: $" + calcularTotal());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Productos de ejemplo
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto("Laptop", 1200, 5));
        productos.add(new Producto("Mouse", 25, 10));
        productos.add(new Producto("Teclado", 45, 7));

        // Cliente de ejemplo
        System.out.print("Ingrese su nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese su apellido: ");
        String apellido = sc.nextLine();
        System.out.print("Ingrese su email: ");
        String email = sc.nextLine();
        System.out.print("Ingrese su telefono: ");
        String telefono = sc.nextLine();
        Cliente cliente = new Cliente(nombre, apellido, email, telefono);

        Carrito carrito = new Carrito();

        int opcion;
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Ver productos");
            System.out.println("2. Agregar producto al carrito");
            System.out.println("3. Ver carrito");
            System.out.println("4. Finalizar compra");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Productos disponibles:");
                    for (int i = 0; i < productos.size(); i++) {
                        Producto p = productos.get(i);
                        System.out.println((i + 1) + ". " + p.nombre + " - $" + p.precio + " (Stock: " + p.stock + ")");
                    }
                    break;
                case 2:
                    System.out.print("Ingrese el número de producto: ");
                    int numProd = sc.nextInt() - 1;
                    if (numProd < 0 || numProd >= productos.size()) {
                        System.out.println("Producto inválido.");
                        break;
                    }
                    Producto prod = productos.get(numProd);
                    System.out.print("Cantidad: ");
                    int cantidad = sc.nextInt();
                    if (cantidad > 0 && cantidad <= prod.stock) {
                        carrito.agregarProducto(prod, cantidad);
                        prod.stock -= cantidad;
                        System.out.println("Producto agregado al carrito.");
                    } else {
                        System.out.println("Cantidad inválida o sin stock suficiente.");
                    }
                    break;
                case 3:
                    carrito.mostrarCarrito();
                    break;
                case 4:
                    carrito.mostrarCarrito();
                    System.out.println("¡Gracias por su compra, " + cliente.nombre + "!");
                    opcion = 0; // salir
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