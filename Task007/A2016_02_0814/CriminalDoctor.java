package Task007.A2016_02_0814;

/**
 * @author Danil Khisamov
 *         11-402
 */
public class CriminalDoctor implements Medical {
    private boolean license;
    private Criminal client;
    private String name;

    public CriminalDoctor(boolean license, Criminal client, String name) {
        this.license = license;
        this.client = client;
        this.name = name;
    }

    @Override
    public String toDiagnose(PoliceOfficer policeOfficer) {
        return ("Болит горло," + policeOfficer.getName() + "? Будем резать");
    }

    @Override
    public String toMakeInjection() {
        return ("Жить будешь");
    }

    @Override
    public String toAskToUndress(PoliceOfficer policeOfficer) {
        return ("Не надо," + policeOfficer.getName() + ", я через одежду рану зашью");
    }

    @Override
    public String toWriteIllegibly() {
        return ("Зачем тебе эта бумажка? Купи активированный уголь");
    }
}
