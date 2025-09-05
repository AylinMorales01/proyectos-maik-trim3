import java.util.Scanner;

public class SumaDigitos {

    public static int sumarDigitos(int numero) {
        numero = Math.abs(numero); // Manejar negativos
        int suma = 0;

        while (numero != 0) {
            int digito = numero % 10; // Obtener último dígito
            suma += digito;           // Sumarlo
            numero /= 10;             // Quitar el dígito
        }

        return suma;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese un número entero: ");
        int numero = scanner.nextInt();

        int suma = sumarDigitos(numero);
        System.out.println("La suma de los dígitos del número es: " + suma);

        scanner.close();
    }
}

