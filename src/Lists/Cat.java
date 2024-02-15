package Lists;

public class Cat {
    String name;
    int age;
    String breed;

    public Cat(String name) {
        this.name = name;
        age = 0;
        breed = "PusPin";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj.equals(this.name)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return name;
    }
}
