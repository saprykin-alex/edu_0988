import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] d = new int[10];                   //Анализируемый массив
        System.out.println("Введите 10 чисел. После каждого числа нажимате клавишу 'Enter'");
        Scanner scan = new Scanner(System.in);
        d[0] = scan.nextInt();                  //Вводим первое число в массив
        int leng[] = {1,1};                      //Длина последовательности {текущая, максимальная}
        int n = 5;                               //Максимальное количество наименьших по длине последовательностей (два числа подряд) в массиве
        int max[][]= new int[n][2];              //Массив (таблица 2 на 5) для сохранения одинаковых по размеру последовательностей

        for (int i = 1; i < 10; i++) {          //Последующий ввод чисел в массив (со 2 по 10)
            d[i] = scan.nextInt();

            if (d[i]==d[i-1])                   //Проверяем, вводится ли повторяющееся число
                leng[0]++;                      //Если введено повторяющееся число, то счётчик длины последовательности инкрементируем
            else{                               //Проверяем, прервался ли ввод повторяющихся чисел
                if (leng[0]>leng[1]) {          //Текущая последовательность больше по длине, чем максимальная, ранее введённая
                    leng[1] = leng[0];
                    n=5;
                    max[n-1][0] = leng[0];
                    max[n-1][1] = d[i-1];
                }
                if (leng[0] == leng[1] && leng[0]>1) {      //Текущая последовательность равна по лоине, чем максимальная, ранее введённая
                    n--;
                    max[n][0] = leng[0];
                    max[n][1] = d[i-1];
                }
                leng[0] = 1;                                //Сбрасываем счётчик текущей последовательности до 1 - введенное число отличается от предыдущего
            }
        }
        //Проверяем величину последовательности с учётом последнего введённого числа
        if (leng[0]>leng[1]) {
            leng[1] = leng[0];
            n=5;
            max[n-1][0] = leng[0];
            max[n-1][1] = d[9];
        }
        if (leng[0] == leng[1] && leng[0]>1) {
            n--;
            max[n][0] = leng[0];
            max[n][1] = d[9];
        }
        //Выводим все равные по длине максимальные последовательности чисел, если таковые были в ведённом массиве
        if (leng[1]>1) {
            n=5;
            do {
                n--;
                System.out.println("Введена максимальная последовательность из " + max[n][0] + " повторяющихся чисел " + max[n][1]);
            }while (n>=1 && max[n][0]==max[n-1][0]);
        }
        else System.out.println("Все введённые числа не образуют повторяющейся последовательности");
    }
}
