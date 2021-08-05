public class Main{
    public static void main(String[] args) {
        Horse horse = new Horse();
        horse.run();
        horse.fly();
        Pegasus pegasus = new Pegasus();
        pegasus.run();
        pegasus.fly();
        pegasus.fly();
        pegasus.run();
        pegasus.run();
    }
}

abstract class Animal{
    public String species; //вид животного
    public int weight;    //вес
    public int paws;  //количество лап
    public int wings; //количество крыльев
}

class Horse extends Animal{
    Horse(){
        this.species = "horse";
        this.paws = 4;
        this.wings = 0;
        this.weight = 330;
    }
    public void run(){ System.out.println("Игого, я поскакала."); }
    public void fly(){ System.out.println("Игого, я - лошадь и летать не умею. Для полётов вызывайте Пегаса."); }
}

class Pegasus extends Animal{
    private boolean isRun;
    Pegasus(){
        this.species = "pegasus";
        this.paws = 4;
        this.wings = 2;
        this.weight = 370;
        this.isRun=false;
    }
    public void run(){
        if(!isRun) {
            System.out.println("Игого, сейчас спущусь с неба на землю и побегу.");
            isRun=true;
        }
        else System.out.println("Игого, уже бегу, но предпочитаю летать.");
    }
    public void fly(){
        if(isRun) {
            System.out.println("Игого, я полетел.");
            isRun = false;
        }
        else System.out.println("Игого, я уже лечу.");
    }
}
