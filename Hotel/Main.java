import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Room[] rooms = {
                new Room((byte) 1,false,false,false, true,(byte) 11),
                new Room((byte) 2,true,true,false, true,(byte) 12),
                new Room((byte) 1,false,true,true, false,(byte) 13),
                new Room((byte) 3,true,false,false, true,(byte) 21),
                new Room((byte) 2,false,false,false, true,(byte) 22),
                new Room((byte) 1,true,true,true, false,(byte) 23),
                new Room((byte) 3,false,true,false, true,(byte) 31),
                new Room((byte) 3,true,true,false, true,(byte) 32),
                new Room((byte) 1,false,false,true, false,(byte) 33),
        };
        Hotel hotel = new Hotel(rooms);
        Scanner scanner = new Scanner(System.in);
        String command;
        while (true){
            System.out.println("Введите команду");
            command = scanner.nextLine();
            if(command.indexOf("getFreeRooms") == 0){
                String[] splitted = command.split(" ");
                if (splitted.length>1){
                    String[] prop = new String[splitted.length-1];
                    for (int i = 1; i < splitted.length; i++)
                        prop[i-1]=splitted[i];
                    hotel.getRoomsWith(prop);
                }else hotel.getFreeRooms();
            }else if(command.equals("propertiesAllRooms")){
                hotel.propertiesAllRooms();
            }else if(command.indexOf("reserve")==0){
                String[] splitted = command.split(" ");
                if (splitted.length>1){
                    for (int i = 1; i < splitted.length; i++) {
                        byte roomNumber = (byte) Integer.parseInt(splitted[i]);
                        hotel.reserveRoom(roomNumber);
                    }
                }else if (splitted.length==1) {
                    //Если не указаны номера комнат, то резервируются все свободные номера
                    for (Room room:rooms) {
                        hotel.reserveRoom(room.getRoomNumber());
                    }
                }
            }else if (command.equals("exit")){
                break;
            }else if (command.equals("commands")){
                System.out.println("getFreeRooms [количество спальных мест] [wc] [eat] [wifi] [conditioner] - вывести список всех свободных комнат, при указании параметров - список свободных комнат с соответствующим сервисом");
                System.out.println("propertiesAllRooms - вывести список всех комнат с их свойствами");
                System.out.println("reserve [номера комнат] резервирование перечисленных номеров, либо всех оставшихся свободных номеров");
                System.out.println("getRoomsWith [количество спальных мест] [wc] [eat] [wifi] [conditioner] - вывод комнат с необходимыми свойствами");
                System.out.println("freeRoom [номер комнаты] - освобождение резерва комнаты (несколько комнат можно ввести через пробел)");
                System.out.println("commands - вывести список всех команд");
                System.out.println("exit - выйти из программы");
            }else if (command.indexOf("getRoomsWith") == 0 ){
                String[] splitted = command.split(" ");
                if (splitted.length>1){
                    String[] prop = new String[splitted.length-1];
                    for (int i = 1; i < splitted.length; i++)
                        prop[i-1]=splitted[i];
                    hotel.getRoomsWith(prop);
                }else hotel.getRoomsWith();
            }else if (command.indexOf("freeRoom") == 0 ){
                String[] splitted = command.split(" ");
                if (splitted.length>1){
                    for (int i = 1; i < splitted.length; i++) {
                        byte roomNumber = (byte) Integer.parseInt(splitted[i]);
                        for (int j = 0; j < rooms.length; j++) {
                            if (rooms[j].getRoomNumber()==roomNumber) rooms[j].setFree(true);
                        }
                    }
                }else if (splitted.length==1) {
                    for (int j = 0; j < rooms.length; j++) {
                        rooms[j].setFree(true);
                    }
                }
            }else System.out.println("Нераспознанная команда ");

        }

    }
}
