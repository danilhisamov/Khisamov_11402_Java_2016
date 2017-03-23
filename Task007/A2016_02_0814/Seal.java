package Task007.A2016_02_0814;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * @author Danil Khisamov
 *         11-402
 */
@Component
public class Seal implements Swimmable {
    @Value("Seal")
    private String name;
    private Collection<Seal> kids;
    @Autowired
    private Eagle fried;

    public String getName() {
        return name;
    }

    @Override
    public String toSwim() {
        return ("Плаваю,но и на суше люблю поваляться");
    }

    @Override
    public String toWaveFlipper() {
        return("Привееет," + fried.getName());
    }

    @Override
    public String toBlowFountain() {
        return("Это не по моей части");
    }

    @Override
    public String toHoldABreath(int k) {
        return("Может я смогу продержаться больше, чем " + k + " минут?");
    }

    public Eagle getFried() {
        return fried;
    }

    public void setFried(Eagle fried) {
        this.fried = fried;
    }
}


