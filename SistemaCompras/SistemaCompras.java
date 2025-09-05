import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaCompras {
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
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Producto> productos = new ArrayList<>();
        productos.add (new Producto ("Camiseta", 10.000, 25));
        productos.add(new Producto("Pantalón", 20.000, 15));
        productos.add(new Producto("Zapatos", 50.000, 10));
        Carrito carrito = new Carrito();

        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese su apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Ingrese su email: ");
        String email = scanner.nextLine();
        System.out.print("Ingrese su teléfono: ");
        String telefono = scanner.nextLine();
        Cliente cliente = new Cliente(nombre, apellido, email, telefono);


        int opcion;
        do {
            System.out.println("\n Bienvenido: ");
            System.out.println("1. Ver productos");
            System.out.println("2. Agregar producto al carrito");
            System.out.println("3. Ver total del carrito");
            System.out.println("4. Pagar");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
        }

        switch (opcion) {
            case 1:
                System.out.println("Productos disponibles:");
                

        
        }
    }
}


