package Task006.A2016_02_0814;

/**
 * @author Danil Khisamov
 *         11-402
 */
public class PoliceDoctor implements Medical {
    private boolean license;
    private Police сlient;
    private String name;

    public void setLicense(boolean license) {
        this.license = license;
    }

    public void setСlient(Police сlient) {
        this.сlient = сlient;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toDiagnose(PoliceOfficer police) {
        return ("Давайте посмотрим что тут у вас, " + police.getName());
    }

    @Override
    public String toMakeInjection() {
        return("Как комарик укусит");
    }

    @Override
    public String toAskToUndress(PoliceOfficer police) {
        return(police.getName() + ", Раздевайтесь");
    }

    @Override
    public String toWriteIllegibly() {
        return("Фыфвфывамооа 2р/д");
    }
}
