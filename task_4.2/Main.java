public class Main {
    public static void main(String[] args) {
        Dog d = new Dog();
        System.out.println(d + " Имя собаки " + d.getName() + "; Возраст собаки " + d.getAge());
        d.setName("Бобик");
        System.out.println(d + " Имя собаки " + d.getName() + "; Возраст собаки " + d.getAge());
        d.setAge(7);
        System.out.println(d + " Имя собаки " + d.getName() + "; Возраст собаки " + d.getAge());
        Dog d1 = new Dog("Тузик");
        System.out.println(d1 + " Имя собаки " + d1.getName() + "; Возраст собаки " + d1.getAge());
        Dog d2 = new Dog(5);
        System.out.println(d2 + " Имя собаки " + d2.getName() + "; Возраст собаки " + d2.getAge());
        Dog d3 = new Dog("Черныш", 3);
        System.out.println(d3 + " Имя собаки " + d3.getName() + "; Возраст собаки " + d3.getAge());
    }
}

class Dog {
    private String name = "Собаку никак не назвали";
    private  int age = -1;
    Dog(){
    }
    Dog(String name, int age){
        this.name = name;
        this.age = age;
    }
    Dog(String name){
        this.name = name;
    }
    Dog(int age){
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge(){
        return this.age;
    }

}
