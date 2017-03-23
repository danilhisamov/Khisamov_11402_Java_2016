package Task006.A2016_02_0814;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Danil Khisamov
 *         11-402
 */
public class MainSpring {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("Task006/spring-config.xml");
        Bandit band1 = (Bandit) ac.getBean("band");
        Ak47 ak47 = (Ak47) ac.getBean("ak47");
        Boss boss = (Boss) ac.getBean("boss");
        PoliceOfficer pof = (PoliceOfficer) ac.getBean("pof");
        BirdPoliceOfficer bpof = (BirdPoliceOfficer) ac.getBean("bpof");
        DolphinPoliceOfficer dpof = (DolphinPoliceOfficer) ac.getBean("dpof");
        M4A4 m4A4 = (M4A4) ac.getBean("m4a4");
        M4A4 m4A4_police = (M4A4) ac.getBean("m4a4_police");
        PoliceDoctor pd = (PoliceDoctor) ac.getBean("pd");
        CriminalDoctor cd = (CriminalDoctor) ac.getBean("cd");
        Eagle eagle = (Eagle) ac.getBean("eagle");
        Seal seal = (Seal) ac.getBean("seal");

        Police[] polices = new Police[3];
        polices[0] = pof;
        polices[1] = bpof;
        polices[2] = dpof;

        for (Police p : polices) {
            p.toArest(band1);
            p.toEatDonut();
            p.toRelease(band1);
            p.toWearPoliceUniform();
        }

        Criminal[] criminals = new Criminal[2];
        criminals[0] = band1;
        criminals[1] = boss;

        for (Criminal c : criminals) {
            c.toBribePolice(pof,20);
            c.toDoABadThing();
            c.toTryRunFromPolice(pof);
            c.toLaunderMoney(15);
        }

        Medical[] medicals = new Medical[2];
        medicals[0] = pd;
        medicals[1] = cd;

        for (Medical m : medicals){
            m.toAskToUndress(pof);
            m.toDiagnose(pof);
            m.toMakeInjection();
            m.toWriteIllegibly();
        }

        Flyable[] flyables = new Flyable[2];
        flyables[0] = bpof;
        flyables[1] = eagle;

        for (Flyable f : flyables){
            f.toDoABarrelRoll();
            f.toFly();
            f.toIncubateEggs();
            f.toRemoveFeathers();
            f.toSing();
        }

        Shootable[] shootables = new Shootable[2];
        shootables[0] = m4A4_police;
        shootables[1] = ak47;

        for (Shootable s : shootables){
            s.toReload();
            s.toCleanGun();
            s.toAim();
            s.toShoot(2);
        }

        Swimmable[] swimables = new Swimmable[2];
        swimables[0] = dpof;
        swimables[1] = seal;

        for (Swimmable s : swimables){
            s.toBlowFountain();
            s.toHoldABreath(2);
            s.toSwim();
            s.toWaveFlipper();
        }

    }
}
