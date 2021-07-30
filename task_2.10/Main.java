public class Main {
    public static void main(String[] args) {
       int[] d = {2,3,4,7,2345,2,2,63,8,3,8,34};
       boolean b = false;
        for (int i = 0; i < d.length-1; i++)
            if (d[i]==d[i+1])
                b=true;
        if (b)
            System.out.println("Да");
        else
            System.out.println("Нет");
    }
}
