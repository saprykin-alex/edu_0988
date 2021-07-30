import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       int[] d = new int[10];
        System.out.println("Введите 10 чисел. После каждого числа нажимате клавишу 'Enter'");
        Scanner scan = new Scanner(System.in);
        d[0] = scan.nextInt();
       int leng[] = {1,1};
       int max = 0;
        for (int i = 1; i < 10; i++) {
            Scanner scan1 = new Scanner(System.in);
            d[i] = scan1.nextInt();
            if (d[i]==d[i-1]) {
                leng[0]++;
            }
            else if (leng[0]>leng[1]){
                leng[1]=leng[0];
                max = d[i];
                leng[0]=1;
            }
            else {
                leng[0]=1;
            }
            if (leng[0]>leng[1]){
                leng[1]=leng[0];
                max = d[i];
            }
        }
           if (leng[1]>1) System.out.println("Введена максимальная последовательность из " + leng[1] + " повторяющихся чисел " + max);
           else System.out.println("Все введённые числа не образуют повторяющейся последовательности");
    }
}
