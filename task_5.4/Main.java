/*
1. Ввести путь к файлу с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
-2
11
3
-5
2
10
Пример вывода:
-2
2
8
10
*/

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        System.out.print("Введите путь к файлу: ");
        String str = scanner.nextLine();
        try{
            FileInputStream fis = new FileInputStream(str);
            int i;
            String result = "";
            while ((i=fis.read())!=-1){
                if (i==13)continue;
                else if (i==10){
                    list.add(Integer.parseInt((result)));
                    result = "";
                }else
                    result += (char) i;
            }
        }catch(Exception ex){
            System.out.println("Что-то пошло не так!");
            System.exit(0);
        }
        Collections.sort(list);     //Сортировка коллекции
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i)%2==0)System.out.println(list.get(i));
        }
    }
}
