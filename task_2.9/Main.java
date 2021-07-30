public class Main {
    public static void main(String[] args) {
       int[] d = {2,3,4,7,2345,2,63,};
       boolean b = false;
        for (int i = 0; i < d.length; i++)
            if (d[i]==5)
                b=true;
        if (b)
            System.out.println("Да");
        else
            System.out.println("Нет");
    }
}
