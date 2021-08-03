/*
Задание: Дан массив с числами. Выведите последовательно его элементы используя рекурсию и не используя цикл.
*/


public class Main {
    public static void main(String[] args) {
        int num[] = {4,2,6,2,65};
        OutArray(num, 0);
    }
    
    static void OutArray(int num[], int pos){
        if (pos<num.length){
            System.out.println(num[pos]);
            OutArray(num, pos+1);
        }
    }
}
