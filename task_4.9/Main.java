import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Person[] persons = {
                new Person("Григорий", "Петров", 15, null, null),
                new Person("Алевтина", "Петрова", 18, null, null),
                new Person("Василий", "Пупкин", 28, null, null),
                new Person("Алексей", "Иванов", 15, null, null),
                new Person("Николай", "Иванов", 20, null, null),
                new Person("Инокентий", "Петров", 48, null, null),
                new Person("Лариса", "Иванова", 38, null, null),
                new Person("Сергей", "Иванов", 41, null, null),
                new Person("Анна", "Петрова", 45, null, null),
                new Person("Мария", "Пупкина", 50, null, null),
                new Person("Алексей", "Петров", 72, null, null),
                new Person("Наталья", "Свиридова", 68, null, null),
                new Person("Светлана", "Васильева", 65, null, null),
                new Person("Николай", "Васильев", 70, null, null),
                new Person("Владимир", "Сидоров", 17, null, null),

        };
        persons[0].mother = persons[8];
        persons[0].father = persons[5];
        persons[1].mother = persons[8];
        persons[1].father = persons[5];
        persons[2].mother = persons[9];
        persons[3].mother = persons[6];
        persons[3].father = persons[7];
        persons[4].mother = persons[6];
        persons[4].father = persons[7];
        persons[5].mother = persons[11];
        persons[5].father = persons[10];
        persons[8].mother = persons[12];
        persons[8].father = persons[13];

        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Введите имя и фамилию");
            String str = scanner.nextLine();
            String[] splited = str.split(" ");
            boolean b=false;
            for (int i = 0; i < persons.length; i++) {
                if (splited[0].equals(persons[i].name) && splited[1].equals(persons[i].lastname)){
                    persons[i].info();
                    b=true;
                }
            }
            if (!b) System.out.println("Указанная персона не найдена в имеющемся справочнике");
        }
    }
}

class Person{
    String name;
    String lastname;
    int age;
    Person mother;
    Person father;
    Person(String name, String lastname, int age, Person mother, Person father){
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.mother = mother;
        this.father = father;
    }

    void info(){

        try {

    System.out.println("Привет! Меня зовут " + this.name + " " + this.lastname + ". Мне " + this.age + ".");
    if (this.mother != null)
        System.out.println("Мою маму зовут " + this.mother.name + " " + this.mother.lastname + ". Ей " + this.mother.age + ".");
    else
        System.out.println("У меня нет матери.");
    if (this.father != null)
        System.out.println("Моего папу зовут " + this.father.name + " " + this.father.lastname + ". Ему " + this.father.age + ".");
    else
        System.out.println("У меня нет отца.");
    if (this.mother.mother != null)
        System.out.println("Мою бабушку со стороны матери зовут " + this.mother.mother.name + " " + this.mother.mother.lastname + ". Ей " + this.mother.mother.age + ".");
    else
        System.out.println("У меня нет бабушки со стороны матери.");
    if (this.mother.father != null)
        System.out.println("Моего дедушку со стороны матери зовут " + this.mother.father.name + " " + this.mother.father.lastname + ". Ему " + this.mother.father.age + ".");
    else
        System.out.println("У меня нет дедушки со стороны матери.");
    if (this.father.mother != null)
        System.out.println("Мою бабушку со стороны отца зовут " + this.father.mother.name + " " + this.father.mother.lastname + ". Ей " + this.father.mother.age + ".");
    else
        System.out.println("У меня нет бабушки со стороны отца.");
    if (this.father.father != null)
        System.out.println("Моего дедушку со стороны отца зовут " + this.father.father.name + " " + this.father.father.lastname + ". Ему " + this.father.father.age + ".");
    else
        System.out.println("У меня нет дедушки со стороны отца.");

        }catch(Exception ex){

        }
    }
}
