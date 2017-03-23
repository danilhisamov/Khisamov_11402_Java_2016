package Task007.A2016_02_0814;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author Danil Khisamov
 *         11-402
 */
@Component
@Qualifier("ak47")
public class Ak47 implements Shootable {
    boolean riflescope;
    boolean silencer;
    @Autowired
    @Qualifier("bandit")
    Criminal owner;

    @Override
    public String toShoot(int k) {return ("Трататата (x" + k + ")");}

    @Override
    public String toReload() {
        return ("Прикройте,перезарежаюсь");
    }

    @Override
    public String toAim() {
        return ("Сейчас будет выстрел в голову!");
    }

    @Override
    public String toCleanGun() {
        return ("Приведем тебя в порядок");
    }
}
