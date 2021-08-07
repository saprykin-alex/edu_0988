import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> names = new ArrayList<>();
        names.add("Анатолий");
        names.add("Георгий");
        names.add("Руслан");
        names.add("Георгий");
        names.add("Павел");
        names.add("Руслан");

        for (int i = 0; i < names.size()-1; i++) {
            for (int j = i+1; j < names.size(); j++) {
                if(names.get(i)== names.get(j))
                    names.remove(j);
            }
        }
        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i));
        }
    }
}
