package Task006.A2016_02_0814;

/**
 * @author Danil Khisamov
 *         11-402
 */
public class DolphinPoliceOfficer implements Police, Swimmable {
    private String name;
    private int rank;
    private Shootable weapon;

    public void setName(String name) {
        this.name = name;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setWeapon(Shootable weapon) {
        this.weapon = weapon;
    }

    @Override
    public String toArest(Bandit bandit) {
        return(bandit.getName() + "`" + bandit.getNickname() + "`, Полиция Майами!");
    }

    @Override
    public String toRelease(Bandit bandit) {
        return(bandit.getName() + "`" + bandit.getNickname() + "`, Всего доброго!");
    }

    @Override
    public String toEatDonut() {
        return("Я предпочел бы рыбу");
    }

    @Override
    public String toWearPoliceUniform() {
        return("Довольно-таки удобно");
    }

    @Override
    public String toSwim() {
        return("Я волна");
    }

    @Override
    public String toWaveFlipper() {
        return("Хей приятель");
    }

    @Override
    public String toBlowFountain() {
        return("Пыщщщ");
    }

    @Override
    public String toHoldABreath(int k) {
        return ("Я могу задержать дыхание на " + k + " минут");
    }
}
