package Task006.A2016_02_0814;

/**
 * @author Danil Khisamov
 *         11-402
 */
public class Boss implements Criminal {
    private String name;
    private Police homie;
    private Criminal rightHand;

    public Boss(String name) {
        this.name = name;
    }

    public void setRightHand(Criminal rightHand) {
        this.rightHand = rightHand;
    }

    public void setHomie(Police homie) {
        this.homie = homie;
    }

    @Override
    public String toDoABadThing() {
        return ("Надо сделать что-то крупное!");
    }

    @Override
    public String toTryRunFromPolice(PoliceOfficer police) {
        return(police.getName() + ", Я слишком стар для этого");
    }

    @Override
    public String toLaunderMoney(int k) {
        return("Чтобы отмыть " + k + " рублей их надо сначала заработать");
    }

    @Override
    public String toBribePolice(PoliceOfficer police, int k) {
        return(police.getName() + ",ты приходишь и просишь что-то у меня, но ты просишь без уважения, ты не предлагаешь мне дружбу, ты даже не называешь меня 'Крестным'");
    }
}
