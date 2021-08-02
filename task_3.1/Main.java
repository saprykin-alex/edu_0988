public class Main {
    public static int min(int a, int b, int c) {
        if ((a<b && a<c) || (a==b && a<c) || (a==c && a<b)) return a;
        if ((b<a && b<c) || (b==c && b<a)) return b;
        if (c<a && c<b) return c;

        return Integer.MIN_VALUE;
    }
    public static void main(String[] args) {
        System.out.println(min(1, 2, 3));
        System.out.println(min(-1, -2, -3));
        System.out.println(min(3, 5, 3));
        System.out.println(min(5, 5, 10));
    }
}
