import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        System.out.println("Введите число (дробная часть отделяется запятой)");
        Scanner scan = new Scanner(System.in);
        float num1 = scan.nextFloat();
        double num2 = num1 + (num1*0.15);
        System.out.println("Число на 15% большее = " + num2);
    }
}
