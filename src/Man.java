public class Man extends Human{
    public Man(String name) {
        super(name);
    }

    @Override
    void shave() {
        System.out.println(name + " is shaving the beard");
    }
}
