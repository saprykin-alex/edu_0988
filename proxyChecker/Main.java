import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("D://java/ip.txt");
            FileOutputStream fos = new FileOutputStream("D://java/good_ip.txt", true);
            int i, j=0;
            String resultIp = "";
            while ((i=fis.read())!=-1){
                if(i==13) continue;
                else if(i==10) {
                    String[] resultIpArray = resultIp.split(":");
                    String ip = resultIpArray[0];
                    int port = Integer.parseInt(resultIpArray[1]);
                    if (checkProxy(ip, port)){
                        j++;
                        String str = ip + ":" + port + String.valueOf(new char[]{10,13});
                        byte[] buffer = str.getBytes();
                        fos.write(buffer);
                        System.out.println("Найден рабочий proxy " + resultIp);
                    }
                    resultIp = "";
                }
                else if (i == 9){
                    resultIp += ":";
                }
                else{
                    resultIp += (char) i;
                }
            }
            System.out.println("Определено " + j + " рабочих proxy-серверов");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static boolean checkProxy(String ip, int port){
        System.out.println("Пробуем подключиться через Proxy " + ip + ":" + port);
        try {
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(ip, port));
            URL url = new URL("https://vozzhaev.ru/test.php");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection(proxy);
            InputStream is = urlConnection.getInputStream();
            BufferedReader rd = new BufferedReader((new InputStreamReader(is)));
            StringBuilder response = new StringBuilder();
            String line = "";
            while ((line = rd.readLine())!=null){
                response.append(line);
            }
            System.out.println(response);
            rd.close();
            return true;

        } catch (IOException e) {
            return false;
        }
    }
}
