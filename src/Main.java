import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Human> humans = new ArrayList<>();
        humans.add(new Woman("Nicole"));
        humans.add(new Man("Joshua"));
        humans.add(new Man("Adrian"));
        humans.add(new Woman("Obando"));
        humans.add(new Man("Jay Vince"));
        for (Human h : humans) {
            h.shave();
        }
        Airplane airplane = new Airplane();
        Bird tweety = new Bird();
        List<Flyable> lupadables = new ArrayList<>();
        lupadables.add(airplane);
        lupadables.add(tweety);
        for (Flyable f : lupadables) {
            f.fly();
        }
    }
}
