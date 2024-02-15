public class Woman extends Human {
    public Woman(String name) {
        super(name);
    }

    @Override
    void shave() {
        System.out.println(name + " is shaving her legs");
    }
}
