package Task007.A2016_02_0814;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Danil Khisamov
 *         11-402
 */
@Qualifier("bpof")
@Component
public class BirdPoliceOfficer implements Police,Flyable {
    @Value("Bird")
    private String name;
    @Value("3")
    private int rank;
    @Autowired
    @Qualifier("m4a4")
    private Shootable weapon;

    public String getName() {
        return name;
    }

    public int getRank() {
        return rank;
    }

    @Override
    public String toFly() {
        return ("Производится проверка территории");
    }

    @Override
    public String toRemoveFeathers() {
        return("Привести крылья в порядок");
    }

    @Override
    public String toIncubateEggs() {
        return("У меня будет целая армия");
    }

    @Override
    public String toSing() {
        return("УиУ Трыт Трыт");
    }

    @Override
    public String toDoABarrelRoll() {
        return("Смотри как я умею");
    }

    @Override
    public String toArest(Bandit bandit) {
        return(bandit.getName() + " `" + bandit.getNickname() +"` ,Воздушная полиция,остановитесь!");
    }

    @Override
    public String toRelease(Bandit bandit) {
        return("Лети," + bandit.getName() + ", на все 4 стороны");
    }

    @Override
    public String toEatDonut() {
        return("А птицы едят пончики?");
    }

    @Override
    public String toWearPoliceUniform() {
        return("Не мой размер,отдам колибри");
    }
}
