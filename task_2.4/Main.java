import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan1 = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        System.out.println("Введите сумму вклада");
        float itog= scan1.nextFloat(); //Использован тип float, поскольку double даёт примерные значения, например, не 1060, а 1059.9995898
        System.out.println("Введите годовой процент по вкладу");
        float procent = scan2.nextFloat() / 100;
        for (int i = 1; i <=5; i++) {
            itog = itog + itog * procent;
            System.out.println(itog);
        }
    }
}
