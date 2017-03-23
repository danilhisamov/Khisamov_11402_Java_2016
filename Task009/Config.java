package Task009;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Danil Khisamov
 *         11-402
 */
@Configuration
@ComponentScan("Task009")
public class Config {

    @Bean
    public ComplexNumber cn1(){
        ComplexNumber cn1 = mock(ComplexNumber.class);
        when(cn1.getRe()).thenReturn(1.0,3.0,5.0,7.0);
        when(cn1.getIm()).thenReturn(2.0,4.0,6.0,8.0);
        return cn1;
    }

    @Bean
    public ComplexNumber cn(){
        ComplexNumber cn1 = mock(ComplexNumber.class);
        when(cn1.getRe()).thenReturn(1.0);
        when(cn1.getIm()).thenReturn(2.0);
        when(cn1.add(any(ComplexNumber.class))).thenReturn(cn1);
        when(cn1.mult(any(ComplexNumber.class))).thenReturn(cn1);
        when(cn1.sub(any(ComplexNumber.class))).thenReturn(cn1);
        return cn1;
    }

    @Bean
    public ComplexNumber cn2(){
        ComplexNumber cn2 = mock(ComplexNumber.class);
        when(cn2.getRe()).thenReturn(3.0);
        when(cn2.getIm()).thenReturn(4.0);
        when(cn2.mult(any (ComplexNumber.class))).thenReturn(cn2);
        return cn2;
    }

    @Bean
    public ComplexMatrix2x2 paramsMatrix(){
        return new ComplexMatrix2x2(cn1(),cn1(),cn1(),cn1());
    }

    @Bean
    public ComplexMatrix2x2 nullMatrix(){
        return new ComplexMatrix2x2();
    }

    @Bean
    public ComplexMatrix2x2 paramMatrix(){
        return new ComplexMatrix2x2(cn());
    }

    @Bean
    public ComplexMatrix2x2 paramMatrix2(){
        return new ComplexMatrix2x2(cn2());
    }

    @Bean
    public ComplexMatrix2x2 detMatrix(){
        return new ComplexMatrix2x2(cn(),cn2(),cn(),cn2());
    }

}


