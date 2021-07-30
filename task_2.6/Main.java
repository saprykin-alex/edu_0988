import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        do{
            Scanner scan1 = new Scanner(System.in);
            System.out.println("Введите число a");
            float a = scan1.nextFloat();
            Scanner scan2 = new Scanner(System.in);
            System.out.println("Введите число b");
            float b = scan2.nextFloat();
            float c = a%b; //Чтобы ниже дважды не выполнять операцию % 
           if (c==0)
               System.out.println("Делится. Результат деления = " + (a/b));
           else
               System.out.println("Делится с остатком " + c);
        }while(true);
    }
}
