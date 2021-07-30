public class Main {
    public static void main(String[] args) {
       int[] d = {2,3,4,5};
       int c = d[0];
        for (int i = 1; i < d.length; i++)
            c=c*d[i];
        System.out.println(c);
    }
}
