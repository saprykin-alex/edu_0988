/*
Задача: Программа определяет, какая семья (фамилию) живёт в доме с указанным номером.
Новая задача: Программа должна работать не с номерами домов, а с городами:
Пример ввода:
Москва
Ивановы
Киев
Петровы
Лондон
Абрамовичи
Лондон
Пример вывода:
Абрамовичи */


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Модернизация ПО
*/

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        while (true) {
            System.out.print("Введите город: ");
            String town = scanner.nextLine();
            if (town.equals("exit") || town.isBlank()) break;
            list.add(town);
            System.out.print("Введите фамилию семьи: ");
            String family = scanner.nextLine();
            if (family.equals("exit") || family.isBlank()) break;
            list.add(family);
        }
        System.out.print("Введите город, чтобы посмотреть, кто в нём живёт: ");
        String town = scanner.nextLine();
        boolean b = true;
        for (int i = 0; i < list.size(); i += 2) {
            if (list.get(i).equals(town)) {
                if (b) {
                    System.out.print("В городе " + town + " живут: " + list.get(i + 1));
                    b = false;
                }else System.out.print(", " + list.get(i + 1));
            }
        }
    }
}
