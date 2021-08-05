public class Main {
    public static void main(String[] args) {
        Person valera=new Person("Валера","Иванов",69,null,null);
        Person olga = new Person("Ольга","Иванова",67,null,null);
        Person oleg = new Person("Олег","Петров",65,null,null);
        Person jula = new Person("Юля","Петрова",67,null,null);
        Person alex = new Person("Алексей","Иванов",37,olga,valera);
        Person eva  = new Person("Ева","Иванова",37,jula,oleg);
        Person gosha= new Person("Гоша","Иванов",10,eva,alex);
        System.out.println("Мама Алексея: "+alex.getMother().getName());
        System.out.println("Бабушка Гоши: "+gosha.getMother().getMother().getName());
        System.out.println("Меня зовут " + gosha.getName() + " " + gosha.getLastname() +
                "\nИмя моей мамы: " + gosha.getMother().getName() + " " + gosha.getMother().getLastname() +
                "\nИмя моего папы: " + gosha.getFather().getName() + " " + gosha.getFather().getLastname());
        if(gosha.getMother().getMother()!=null && gosha.getFather().getMother()!=null)
            System.out.println("У меня две бабушки, бабушка " + gosha.getMother().getMother().getName() +
                    " " + gosha.getMother().getMother().getLastname() +
                    " и " + gosha.getFather().getMother().getName() + " " + gosha.getFather().getMother().getLastname() + "\n" +
                "У меня два дедушки, дедушка " + gosha.getMother().getFather().getName() +
                    " " + gosha.getMother().getFather().getLastname() +
                    " и " + gosha.getFather().getFather().getName() + " " + gosha.getFather().getFather().getLastname());
    }
}

class Person{
    private String name;
    private String lastname;
    private int age;
    private Person mother;
    private Person father;
    public Person(String name, String lastname, int age, Person mother, Person father){
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.mother = mother;
        this.father = father;
    }
    public String getName() { return this.name;}
    public String getLastname() { return this.lastname;}
    public int getAge(){ return this.age;}
    public void setAge(int age){ this.age = age; }
    public Person getMother(){ return this.mother; }
    public Person getFather(){ return this.father; }
}
