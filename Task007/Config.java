package Task007;

import Task007.A2016_02_0814.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
/**
 * @author Danil Khisamov
 *         11-402
 */
@Configuration
@ComponentScan("Task007.A2016_02_0814")
public class Config {
    @Autowired
    Bandit bandit;
    @Autowired
    M4A4 m4A4;


    @Bean
    public DolphinPoliceOfficer dpof(){
        return new DolphinPoliceOfficer("Dolphin",2,m4A4);
    }

    @Bean
    public CriminalDoctor cd(){
        return new CriminalDoctor(false,boss(),"CDoctor");
    }

    @Bean
    public Boss boss(){
        return new Boss("Дон Карлеон",pof(),bandit);
    }

    @Bean
    public PoliceOfficer pof(){
        return new PoliceOfficer("PoliceOf",2);
    }
}
