/*
 * Задание: Дана коллекция с числами. Запишите в новую коллекцию только те числа, которые больше нуля и меньше 10-ти.
 * Коллекции вы создаёте сами
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        Integer num;
        while (true) {
            System.out.print("Введите число в коллекцию: ");
            String str = scanner.nextLine();
            if (str.isBlank()) break;
            num = Integer.parseInt(str);
            list1.add(num);
            if (num>0 && num<10)list2.add(num);
        }
        System.out.println("Получились две коллекции чисел: ");
        for (int i = 0; i < list1.size(); i ++) {
            System.out.print(list1.get(i) + "\t\t");
            if (i < list2.size())System.out.print(list2.get(i));
            System.out.println();
        }
    }
}
