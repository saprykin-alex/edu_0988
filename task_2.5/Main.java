import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        do{
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите число");
        float a = scan.nextFloat();
           if (a==10)
               System.out.println("Верно!");
           else
               System.out.println("Не верно");
        }while(true);
    }
}
