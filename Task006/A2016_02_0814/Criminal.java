package Task006.A2016_02_0814;

/**
 * @author Danil Khisamov
 *         11-402
 */
public interface Criminal {
    String toDoABadThing();
    String toTryRunFromPolice(PoliceOfficer police);
    String toLaunderMoney(int k);
    String toBribePolice(PoliceOfficer police,int k);
}
