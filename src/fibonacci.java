import java.util.Scanner;

public class fibonacci {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe um numero para verificar se pertence à sequencia de Fibonacci: ");
        int numero = scanner.nextInt();

        scanner.close();

        int a = 0;
        int b = 1;

        int fib = 0;

        if (numero == 0 || numero == 1) {
            System.out.println("O numero " + numero + " pertence à sequencia de Fibonacci.");
            return;
        }

        while (fib < numero) {
            fib = a + b;
            a = b;
            b = fib;
        }

        if (fib == numero) {
            System.out.println("O numero " + numero + " pertence à sequencia de Fibonacci.");
        } else {
            System.out.println("O numero " + numero + " nao pertence à sequencia de Fibonacci.");
        }
    }
}
