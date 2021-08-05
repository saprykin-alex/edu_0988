/*
Создай классы Dog, Cat, Mouse.
Добавь по три поля в каждый класс, на твой выбор.
Создай объекты для героев мультика Том и Джерри.
Так много, как только вспомнишь.
Пример:
Mouse jerryMouse = new Mouse("Jerry", 12 , 5),
где 12 - высота в см,
5 - длина хвоста в см.
Требования:
•	Создай класс Dog.
•	Создай класс Cat.
•	В классе Dog должно быть три переменные.
•	В классе Cat должно быть три переменные.
•	Должен быть создан хотя бы один объект типа Mouse.
•	Должен быть создан хотя бы один объект типа Dog.
•	Должен быть создан хотя бы один объект типа Cat.
*/

public class Main {
    public static void main(String[] args) {
        Mouse jerryMouse = new Mouse("Jerry", 12, 5);
        Cat tomCat = new Cat("Tom", "Mice", false);
        Dog bobikDog = new Dog("Bobik", "Дворняга", 7);
        if (tomCat.sleeps)
            System.out.println("Кот " + tomCat.name + " любит кушать таких как " + jerryMouse.name + ", но сейчас он спит");
        else
            System.out.println("Кот " + tomCat.name + " любит кушать " + tomCat.food + ", сейчас он охотится на " + jerryMouse.name);
    }
}
class Mouse {
    String name;
    int height;
    int tail;

    public Mouse(String name, int height, int tail) {
        this.name = name;
        this.height = height;
        this.tail = tail;
    }
}
class Dog {
    String name;
    String breed;   //порода
    int award;   //Количество наград

    public Dog(String name, String breed, int award) {
        this.name = name;
        this.breed = breed;
        this.award = award;
    }
}
class Cat {
    String name;
    String food;  //Любимая еда
    boolean sleeps; //Спит или не спит

    public Cat(String name, String food, boolean sleeps) {
        this.name = name;
        this.food = food;
        this.sleeps = sleeps;
    }
}
