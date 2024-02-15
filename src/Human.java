public abstract class Human extends Object {
    String name;

    public Human(String name) {
        this.name = name;
    }

    abstract void shave();
}
