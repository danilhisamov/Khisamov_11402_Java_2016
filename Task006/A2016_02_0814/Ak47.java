package Task006.A2016_02_0814;

/**
 * @author Danil Khisamov
 *         11-402
 */
public class Ak47 implements Shootable {
    boolean riflescope;
    boolean silencer;
    Criminal owner;

    public Ak47(Criminal owner) {
        this.owner = owner;
    }

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
