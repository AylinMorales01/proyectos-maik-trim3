import java.util.Scanner;

public class HolaMundo {
  public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el primer número: ");
        Integer num1 = scanner.nextInt();

        System.out.print("Ingrese el segundo número: ");
        Integer num2 = scanner.nextInt();

        Integer suma = num1 + num2;

        System.out.println("La suma es: " + suma);

        scanner.close();
    }
}