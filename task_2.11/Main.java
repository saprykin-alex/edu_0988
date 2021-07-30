public class Main {
    public static void main(String[] args) {
       int[] d = {2,3,14,7,2345,2,2,63,8,3,8,34};
       int sum=d[0];
       int num = 1;
        for (int i = num; i < d.length; i++) {
            sum=sum+d[i];
            if (sum>10){
                num=i+1;
                break;
            }
        }
           System.out.println(num + " " + sum); //3 19
    }
}
