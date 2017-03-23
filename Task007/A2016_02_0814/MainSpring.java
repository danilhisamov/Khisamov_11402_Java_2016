package Task007.A2016_02_0814;

import Task007.Config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Danil Khisamov
 *         11-402
 */
public class MainSpring {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);

        Bandit bandit = (Bandit) ac.getBean("bandit");
        Boss boss = (Boss) ac.getBean("boss");
        Eagle eagle =(Eagle) ac.getBean("eagle");
        Seal seal =(Seal) ac.getBean("seal");
        DolphinPoliceOfficer dpof = (DolphinPoliceOfficer) ac.getBean("dpof");
        Ak47 ak47 = (Ak47) ac.getBean("ak47");
        BirdPoliceOfficer bpof = (BirdPoliceOfficer) ac.getBean("birdPoliceOfficer");
        CriminalDoctor cd = (CriminalDoctor) ac.getBean("cd");
        PoliceOfficer pof = (PoliceOfficer) ac.getBean("pof");
        PoliceDoctor pd = (PoliceDoctor) ac.getBean("policeDoctor");
        M4A4 m4a4 = (M4A4) ac.getBean("m4A4");

        Police[] polices = new Police[3];
        polices[0] = pof;
        polices[1] = bpof;
        polices[2] = dpof;

        for (Police p : polices) {
            p.toArest(bandit);
            p.toEatDonut();
            p.toRelease(bandit);
            p.toWearPoliceUniform();
        }

        Criminal[] criminals = new Criminal[2];
        criminals[0] = bandit;
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
        shootables[0] = m4a4;
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
