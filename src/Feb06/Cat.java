package Feb06;

public class Cat extends Object{
    String name;
    private int age;

    public Cat(String name) {
        this.name = name;
    }
    public Cat(String name, int age) throws BadAgeException {
        this.name = name;
        if (age < 0) {
            throw new BadAgeException("Cats cannot be predicted into the future");
        }
        this.age = age;
    }

    public Cat(int age) throws BadAgeException {
        this("Catty", age);
    }

    public int getAge() {
        return age;
    }

    public void birthday() {
        int oldAge = age;
        age--;
        System.out.println("Happy bday! You are "+ age
                +" years old");
        assert age > oldAge : "Age must increase on birthdays";
    }

    protected void setAge(int age) throws BadAgeException {
        if (age < 0) {
            throw new BadAgeException();
        }
        this.age = age;
    }

    void pet_the_cat() {
        System.out.println(name + ": Mrow ayaw kog himoag siomai plss");
    }
}
