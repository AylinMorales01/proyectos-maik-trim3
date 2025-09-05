import java.util.Scanner;

public class DigitosNum {
    public static int contarDigitos(int numero) {
        Integer contador = 0;
        if (numero == 0) {
            return 1; // El número 0 tiene un dígito
        }
        while (numero != 0) {
            numero /= 10;
            contador++;
        }
        return contador;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese un número entero: ");
        int numero = scanner.nextInt();

        int cantidadDigitos = contarDigitos(numero);
        System.out.println("El número " + numero + " tiene " + cantidadDigitos + " dígitos.");
        scanner.close();
    }
}


