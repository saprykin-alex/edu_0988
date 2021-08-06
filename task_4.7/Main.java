/*
Реализуй в классе Fox интерфейс Animal.
Учти, что создавать дополнительные классы и удалять методы нельзя!
Требования:
•	Интерфейс Animal должен быть реализован в классе Fox.
•	В интерфейсе Animal нужно объявить метод getColor.
•	Дополнительные классы или интерфейсы создавать нельзя.
*/

import java.awt.*;

public class Main {
    public static void main(String[] args){
        Fox fox = new Fox();
        Animal colorfox = fox;

        System.out.println(fox.getName() + " has color: r=" + colorfox.getColor().getRed() + "; g=" + colorfox.getColor().getGreen() + " b=" + colorfox.getColor().getBlue());
    }
}

interface Animal {
    Color getColor();
}

class Fox implements Animal{
    public String getName() {
        return "Fox";
    }

    public Color getColor(){
       return Color.red;
    }
}

