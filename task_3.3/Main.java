/*
Задание: Сделайте функцию, которая параметрами принимает 2 числа. Если эти числа равны - пусть функция вернет true, а если не равны - false.
*/


public class Main {
    public static void main(String[] args) {
        System.out.println(equality(12122, 121522));
    }
    static boolean equality(int a, int b) {
        if (a==b) return true;
        else return false;
    }

}
