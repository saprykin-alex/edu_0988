import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class MultiThread3 {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("D://java/ip.txt");
            FileOutputStream fos = new FileOutputStream("D://java/good_ip.txt", true);
            ArrayList<Thread> threads= new ArrayList<>();
            int i, j=0, k=0;
            String resultIp = "";
            while ((i=fis.read())!=-1){
                if(i==13) continue;
                else if(i==10) {
                    String[] resultIpArray = resultIp.split(":");
                    String ip = resultIpArray[0]; // Сохраняем ip
                    int port = Integer.parseInt(resultIpArray[1]); // Сохраняем порт, т.к. это строка, сначала преобразуем в число
                    threads.add(new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(ip, port));
                                URL url = new URL("https://vozhzhaev.ru/test.php");
                                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection(proxy);
                                InputStream is = urlConnection.getInputStream();
                                BufferedReader rd = new BufferedReader((new InputStreamReader(is)));
                                StringBuilder response = new StringBuilder();
                                String line = "";
                                while ((line = rd.readLine()) != null) {
                                    response.append(line);
                                }
                                System.out.println("Получен ответ, наш ip " + response);
                                rd.close();
                                FileOutputStream fos = new FileOutputStream("D://java/good_ip.txt", true);
                                byte[] buffer = (ip + ":" + port + "\r\n").getBytes();
                                fos.write(buffer);
                                fos.close();
                            } catch (IOException e) {
                                System.out.println("Нерабочий ip " + ip + ":" + port);
                            }
                        }
                    }));
                    threads.get(k).start();
                    k++;
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
}


