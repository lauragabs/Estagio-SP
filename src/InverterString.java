import java.util.Scanner;

public class InverterString {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite a string que sera invertida:");
        String input = scanner.nextLine();
        scanner.close();

        String invertedString = inverterString(input);


        System.out.println("String invertida: " + invertedString);
    }

    public static String inverterString(String str) {
        char[] chars = str.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }

        return new String(chars);
    }
}
