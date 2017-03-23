package Task007.A2016_02_0814;

/**
 * @author Danil Khisamov
 *         11-402
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Ak47 ak47m = new Ak47M();
        ak47m.toShoot(2);

        Bandit band1 = new Bandit("Владимир", "Утюг");
        Boss boss = new Boss();

        PoliceOfficer pof = new PoliceOfficer("Bob", 2);
        BirdPoliceOfficer bpof = new BirdPoliceOfficer();
        DolphinPoliceOfficer dpof = new DolphinPoliceOfficer("DOl",2,ak47m);

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

        PoliceDoctor pd = new PoliceDoctor();
        CriminalDoctor cd = new CriminalDoctor(true,boss,"Bob");

        Medical[] medicals = new Medical[2];
        medicals[0] = pd;
        medicals[1] = cd;

        for (Medical m : medicals){
            m.toAskToUndress(pof);
            m.toDiagnose(pof);
            m.toMakeInjection();
            m.toWriteIllegibly();
        }

        Eagle eagle = new Eagle();

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

        M4A4 m4a4 = new M4A4();
        Ak47 ak47 = new Ak47();

        Shootable[] shootables = new Shootable[2];
        shootables[0] = m4a4;
        shootables[1] = ak47;

        for (Shootable s : shootables){
            s.toReload();
            s.toCleanGun();
            s.toAim();
            s.toShoot(2);
        }

        Seal seal = new Seal();

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
