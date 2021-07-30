import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        do {
            Scanner scan = new Scanner(System.in);
            System.out.println("Введите число");
            int a = scan.nextInt();
            boolean b = false;
            int c=a;
         while (c > 2) {
             c--;
             if (a % c == 0)
                 b = true;
         };
         System.out.println(b);
     }while (true);
    }
}
