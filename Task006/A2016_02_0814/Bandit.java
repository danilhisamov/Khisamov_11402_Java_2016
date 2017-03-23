package Task006.A2016_02_0814;

/**
 * @author Danil Khisamov
 *         11-402
 */
public class Bandit implements Criminal {
    private String name;
    private String nickname;
    private Shootable weapon;

    public void setWeapon(Shootable weapon) {
        this.weapon = weapon;
    }

    public String getName() {
        return name;
    }

    public String getNickname() {
        return nickname;
    }

    public Bandit(String name, String nickname) {
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toDoABadThing() {
        String s  = "Haha!I am a bad guy";
        if (weapon != null) {
            s += weapon.toShoot(2);
        }

        return s;
    }

    @Override
    public String toTryRunFromPolice(PoliceOfficer police) {
        return("Беги " + police.getName() +", лес которым управляют");
    }

    @Override
    public String toLaunderMoney(int k) {
        return("От куда эти " + k + " рублей такие чистые? Я просто использую 'Ласка Магия Зеленого'");
    }

    @Override
    public String toBribePolice(PoliceOfficer police, int k) {
        return ("Начальник(ранга " + police.getRank() +") " + police.getName() + ",может договоримся?(Протянуть " + k + " рублей)");
    }
}
