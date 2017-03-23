package Task006.A2016_02_0814;

/**
 * @author Danil Khisamov
 *         11-402
 */
public class M4A4 implements Shootable {
    boolean riflescope;
    boolean silencer;
    Police owner;

    public void setRiflescope(boolean riflescope) {
        this.riflescope = riflescope;
    }

    public void setSilencer(boolean silencer) {
        this.silencer = silencer;
    }

    public void setOwner(Police owner) {
        this.owner = owner;
    }

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
