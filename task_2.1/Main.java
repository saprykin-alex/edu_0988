public class Main {
    public static void main(String[] args) {
        String[] str = {"Мама", "Мыла", "Раму"};
        int ind = 0;
        for (int i = 0; i < str.length; i++)
            for (int j = 0; j < str.length; j++)
                for (int k = 0; k < str.length; k++)
                    if (i != j && i != k && j != k) {
                        System.out.println(str[i] + str[j] + str[k]);
                        ind++;
                    }
        System.out.println("Всего " + ind + " комбинаций");
    }
}
