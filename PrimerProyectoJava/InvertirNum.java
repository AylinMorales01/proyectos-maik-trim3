import java.util.Scanner;

public class InvertirNum {
    public static int invertirNumero(int numero) {
        int invertido = 0;
        while (numero != 0) {
            invertido = invertido * 10 + numero % 10; // Agregar el último dígito al número invertido
            numero /= 10; // Eliminar el último dígito del número original
        }
        return invertido;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese un número entero: ");
        int numero = scanner.nextInt();

        int numeroInvertido = invertirNumero(numero);
        System.out.println("El número invertido es " + numeroInvertido);
        scanner.close();
    }
}
