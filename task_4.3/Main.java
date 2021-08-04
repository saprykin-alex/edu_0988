public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat();
        cat1.age = 9;
        cat1.weight = 4;
        cat1.strength = 4;
        Cat cat2 = new Cat();
        cat2.age = 10;
        cat2.weight = 5;
        cat2.strength = 3;
        System.out.println(cat1.fight(cat2));
    }
}

class Cat {
    public int age;
    public int weight;
    public int strength;

    public Cat() {
    }

    public boolean fight(Cat anotherCat) {
        byte victory = 0;
        if (this.age> anotherCat.age)victory++;
        if (this.weight> anotherCat.weight)victory++;
        if (this.strength> anotherCat.strength)victory++;
        if (victory>1) return true;
        return false;
    }
}
