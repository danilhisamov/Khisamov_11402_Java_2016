package A2016_02_0814;

/**
 * @author Danil Khisamov
 *         11-402
 */
public class M4A4 implements Shootable {
    boolean riflescope;
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
