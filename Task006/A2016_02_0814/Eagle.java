package Task006.A2016_02_0814;

import java.util.Collection;

/**
 * @author Danil Khisamov
 *         11-402
 */
public class Eagle implements Flyable {
    private String name;
    private Collection<Eagle> kids;
    private Seal friend;

    public Eagle(){}

    public Eagle(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setKids(Collection<Eagle> kids) {
        this.kids = kids;
    }

    public void setFriend(Seal friend) {
        this.friend = friend;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toFly() {
        return ("Просто летающий орёл,ничего удивительного");
    }

    @Override
    public String toRemoveFeathers() {
        return("Старею,надо брать средство от седины");
    }

    @Override
    public String toIncubateEggs() {
        return("Будет кем покомандовать");
    }

    @Override
    public String toSing() {
        return("(Устрашающий крик)");
    }

    @Override
    public String toDoABarrelRoll() {
        return("Бочка??Серьезно?");
    }
}
