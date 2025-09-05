import java.util.Scanner;

public class SerieFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el número de dígitos de la serie Fibonacci que quiera ver: ");
        int n = scanner.nextInt();

        int a = 0, b = 1;

        System.out.println("Serie Fibonacci de " + n + " términos:");
        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");

            int siguiente = a + b;
            a = b;              
            b = siguiente;      
        }

        scanner.close();
    }
}

