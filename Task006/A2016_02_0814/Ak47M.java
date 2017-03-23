package Task006.A2016_02_0814;

/**
 * @author Danil Khisamov
 *         11-402
 */
public class Ak47M extends Ak47 implements Shootable{
    boolean riflescope;
    boolean silencer;
    Criminal owner;
    boolean extraMagazine;

    public Ak47M(Criminal owner) {
        super(owner);
    }

    @Override
    public String toShoot(int k){
        return ("Ak47M shoots " + k + " times");
    }

}
