package Task007.A2016_02_0814;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * @author Danil Khisamov
 *         11-402
 */
@Component
public class Eagle implements Flyable {
    @Value("Eagle")
    private String name;
    private Collection<Eagle> kids;
    @Autowired
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

    public Seal getFriend() {
        return friend;
    }
}
