package Task007.A2016_02_0814;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Danil Khisamov
 *         11-402
 */
@Component
public class PoliceDoctor implements Medical {
    @Value("true")
    private boolean license;
    @Autowired
    @Qualifier("bpof")
    private Police сlient;
    @Value("PDoctor")
    private String name;

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
