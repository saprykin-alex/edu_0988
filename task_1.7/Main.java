import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        System.out.println("Введите длину бассейна в метрах");
        Scanner scan1 = new Scanner(System.in);
        int num1 = scan1.nextInt();
        System.out.println("Введите ширину бассейна в метрах");
        Scanner scan2 = new Scanner(System.in);
        int num2 = scan2.nextInt();
        System.out.println("Введите глубину бассейна в метрах");
        Scanner scan3 = new Scanner(System.in);
        int num3 = scan3.nextInt();
        int vol = num1*num2*num3*1000;
        System.out.println("Для заполнения бассена необходимо " + vol + " литров воды");
    }
}
