import java.util.Scanner;

    public class Multiplos3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese un número entero: ");
        int numero = scanner.nextInt();

        System.out.println("Los múltiplos de 3 menores que " + numero + " son:");
        for (int i = 1; i <= numero; i++) {
            if (i % 3 == 0) {
                System.out.print(i + " ");
            }
        }
        scanner.close();
    }   
}
