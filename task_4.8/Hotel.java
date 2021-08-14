import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Hotel {
    Room[] rooms;

    public Hotel(Room[] rooms) {
        this.rooms = rooms;
    }
    //Выводим список всех свободных комнат
    public void getFreeRooms(){
        String freeRoomsList = "";
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].isFree()) freeRoomsList += " " + rooms[i].getRoomNumber();
        }
        System.out.println("Номера свободных комнат "+freeRoomsList);
    }
    //Выводим свободные комнаты с перечисленными характеристиками
    public void getFreeRooms(String[] prop){
        ArrayList<Room> freeRooms = new ArrayList<>();
        //Создаём список свободных комнат
        for (int i = 0; i < rooms.length; i++)
            if (rooms[i].isFree()) freeRooms.add(rooms[i]);
        getRooms(freeRooms, prop);
    }
    //Вывод комнат со всеми характеристиками вне зависимости от того, свободна комната или нет
    public void getRoomsWith(){
        propertiesAllRooms();
    }
    //Вывод комнат с указанными характеристиками вне зависимости от того, свободна комната или нет
    public void getRoomsWith(String[] prop){
        //Создаём список всех комнат
        ArrayList<Room> allRooms = new ArrayList<>();
        for (int i = 0; i < rooms.length; i++)
            allRooms.add(rooms[i]);
        getRooms(allRooms, prop);
    }

    private void getRooms(ArrayList<Room> selectedRooms, String[] prop){
        ArrayList<Room> itogList = new ArrayList<>();
        String result = "По данному запросу найдены комнаты:";
        boolean[] roomServices = {false, false, false};        //wc, eat, wifi
        boolean isRoomServices = false;
        boolean[] roomQuantity = {false, false, false};        //1, 2, 3
        boolean isRoomQuantity = false;

        //Проверяем наличие в запросе указанных характеристик номеров комнат
        for (int i = 0; i < prop.length; i++) {
            if (prop[i].equals("WC") || prop[i].equals("wc") || prop[i].equals("Wc") || prop[i].equals("wC")){
                roomServices[0]=true;
                isRoomServices = true;
            }
            if (prop[i].equals("eat") || prop[i].equals("Eat") || prop[i].equals("EAT") || prop[i].equals("EAt")){
                roomServices[1]=true;
                isRoomServices = true;
            }
            if (prop[i].equals("wifi") || prop[i].equals("wi-fi") || prop[i].equals("Wi-Fic") || prop[i].equals("WiFi") || prop[i].equals("WIFI")){
                roomServices[2]=true;
                isRoomServices = true;
            }
            //Проверяем скольки местные номера указаны в запросе. В проверке учитываем, что пользователь может ввести несколько значений, в том числе и одинаковых
            if (prop[i].equals("1")){
                roomQuantity[0]=true;
                isRoomQuantity = true;
            }
            if (prop[i].equals("2")){
                roomQuantity[1]=true;
                isRoomQuantity = true;
            }
            if (prop[i].equals("3")){
                roomQuantity[2]=true;
                isRoomQuantity = true;
            }
        }

        if (isRoomQuantity){
            for (int i = 0; i < 3; i++) {
                if (roomQuantity[i]) {
                    for (int j = 0; j < selectedRooms.size(); j++) {
                        if (i == 0) {
                            if (selectedRooms.get(j).getQuantity() == 1) {
                                itogList.add(selectedRooms.get(j));
                            }
                        }
                        if (i == 1) {
                            if (selectedRooms.get(j).getQuantity() == 2) {
                                itogList.add(selectedRooms.get(j));
                            }
                        }
                        if (i == 2) {
                            if (selectedRooms.get(j).getQuantity() == 3) {
                                itogList.add(selectedRooms.get(j));
                            }
                        }
                    }
                } else continue;
            }
            if (isRoomServices) {
                selectedRooms.clear();
                selectedRooms.addAll(itogList);
                itogList.clear();
                itogList = getItogList(selectedRooms, roomServices);    //Вынес повторяющийся код в отдельный метод
            }
        }else if (isRoomServices) {         //Выборка комнат по параметрам
            itogList = getItogList(selectedRooms, roomServices);    //Вынес повторяющийся код в отдельный метод
        }else{
            System.out.println("Ошибка в параметрах");
            return;
        }
        if (itogList.size()>0) {
            //Сортируем список по номеру комнаты
            Collections.sort(itogList, Comparator.comparing(Room::getRoomNumber));
            //Добавляем номера комнат в результирующую строку
            for (int i = 0; i < itogList.size(); i++)
                result += " " + itogList.get(i).getRoomNumber();
            //Выводим список номеров комнат
        }else result = "По данному запросу нет комнат";
        System.out.println(result);
    }

    private ArrayList<Room> getItogList(ArrayList<Room> selectedRooms,  boolean[] roomServices){
        ArrayList<Room> itogList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (roomServices[i]){
                for (int j = 0; j < selectedRooms.size(); j++) {
                    if (i==0){
                        if (selectedRooms.get(j).isWc()) itogList.add(selectedRooms.get(j));
                    }
                    if (i==1){
                        if (selectedRooms.get(j).isEat()) itogList.add(selectedRooms.get(j));
                    }
                    if (i==2){
                        if (selectedRooms.get(j).isWifi()) itogList.add(selectedRooms.get(j));
                    }
                }
            }else continue;
            selectedRooms.clear();
            selectedRooms.addAll(itogList);
            itogList.clear();
        }
        return selectedRooms;
    }

    public void reserveRoom(byte roomNumber){
        String info = "Такой комнаты не существует";
        for (int i = 0; i < rooms.length; i++) {
            Room room = rooms[i];
            if(room.getRoomNumber() == roomNumber && room.isFree()){
                room.setFree(false);
                info = ("Комната номер "+roomNumber+" успешно забронированна");
                break;
            }else if(room.getRoomNumber() == roomNumber && !room.isFree()){
                info = "Комната "+roomNumber+" занята";
                break;
            }
        }
        System.out.println(info);
    }
    //Вывод всех комнат со всеми характеристиками
    public void propertiesAllRooms(){
        //System.out.println("Номер комнаты\tКоличество мест\tНаличие туалета\tПитание включено\tНаличие Wi-Fi\tНомер занят");
        System.out.println(" Номер \t\tКоличество\tНаличие\t\tПитание\t\tНаличие\t\tНомер");
        System.out.println("комнаты\t\t   мест   \tтуалета\t\tвключено\t Wi-Fi \t\tзанят");

        for (int i = 0; i < rooms.length; i++) {
            System.out.print("  " + rooms[i].getRoomNumber() + "\t\t\t");
            System.out.print(rooms[i].getQuantity() + "\t\t  ");
            if (rooms[i].isWc()) System.out.print("Да\t\t  "); else System.out.print("Нет\t\t  ");
            if (rooms[i].isEat()) System.out.print("Да\t\t  "); else System.out.print("Нет\t\t  ");
            if (rooms[i].isWifi()) System.out.print("Да\t\t "); else System.out.print("Нет\t\t ");
            if (rooms[i].isFree()) System.out.print("Нет\t\t"); else System.out.print("Да\t\t");
            System.out.println();
        }
    }

}
