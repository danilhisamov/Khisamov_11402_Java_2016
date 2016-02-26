package A2016_02_0814;

import java.util.Collection;

/**
 * @author Danil Khisamov
 *         11-402
 */
public class Seal implements Swimmable {
    private String name;
    private Collection<Seal> kids;
    private Eagle fried;

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


