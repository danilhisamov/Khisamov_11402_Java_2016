package Task006.A2016_02_0814;

/**
 * @author Danil Khisamov
 *         11-402
 */
public class PoliceOfficer implements Police{
    private String name;
    private int rank;
    private Criminal informer;

    public void setInformer(Criminal informer) {
        this.informer = informer;
    }

    public PoliceOfficer(String name, int rank) {
        this.name = name;
        this.rank = rank;
    }

    @Override
    public String toArest(Bandit bandit) {
        rank++;
        return (bandit.getName() + "`" + bandit.getNickname() + "`, Freeze police!");
    }

    public String getName() {
        return name;
    }

    public int getRank() {
        return rank;
    }

    @Override
    public String toRelease(Bandit bandit) {
        return("Иди," + bandit.getName() + "`" + bandit.getNickname() + "`, пока я не передумал");
    }

    @Override
    public String toEatDonut() {
        return("Ммм,обожаю свою работу!");
    }

    @Override
    public String toWearPoliceUniform() {
        return("Ну вы только посмотрите на этого красавчика!");
    }
}
