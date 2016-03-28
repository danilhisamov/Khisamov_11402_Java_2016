package Task007.A2016_02_0814;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Danil Khisamov
 *         11-402
 */
@Component
@Qualifier("m4a4")
@Scope("prototype")
public class M4A4 implements Shootable {
    boolean riflescope;
    @Value("true")
    boolean silencer;
    Police owner;

    @Override
    public String toShoot(int k) {
        return ("Tratatata");
    }

    @Override
    public String toReload() {
        return ("Cover me,I am reloading!");
    }

    @Override
    public String toAim() {
        return ("It will be a headshot");
    }

    @Override
    public String toCleanGun() {
        return ("Let's make you clean");
    }
}
