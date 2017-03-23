package A2016_02_0814;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Collection;

/**
 * @author Danil Khisamov
 *         11-402
 */
public class Eagle implements Flyable {
    private String name;
    private Collection<Eagle> kids;
    private Seal friend;

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
