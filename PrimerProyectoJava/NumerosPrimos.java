import java.util.Scanner;

public class NumerosPrimos {
    

    public static boolean esPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }
        for (int i = 2; i * i <= numero; i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese un número entero: ");
        int numero = scanner.nextInt();

        if (esPrimo(numero)) {
            System.out.println("El número " + numero + " es un número primo.");
        } else {
            System.out.println("El número " + numero + " no es un número primo.");
        }
        scanner.close();
    }
}