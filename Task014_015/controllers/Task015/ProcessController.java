package controllers.Task015;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Danil Khisamov
 *         11-402
 */
@Controller
@RequestMapping("/process")
public class ProcessController {
    @RequestMapping(method = RequestMethod.GET)
    public String showForm(){
        return "Task15/process";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String showRes(ModelMap mm, @RequestParam(name = "text") String s,@RequestParam(name = "choice") String proc){
        int k = 0;
        String oper = "";
        if (proc.equals("count_char")){
            k = s.length();
            oper = "Количество символов : ";
        }else if (proc.equals("count_word")){
            Pattern p = Pattern.compile("([A-Z]|[a-z])+");
            Matcher m = p.matcher(s);
            while (m.find()){
                k++;
            }
            oper = "Количество слов : ";
        }else if (proc.equals("count_sent")){
            Pattern p = Pattern.compile("(([A-Z]|[a-z]|[\\s,-])+[\\.\\?!]+)");
            Matcher m = p.matcher(s);
            while (m.find()){
                k++;
            }
            oper = "Количество предложений : ";
        }else if (proc.equals("count_par")){
            Pattern p = Pattern.compile("((\\s\\s(([A-Z]|[a-z\\s,-])+[\\.\\?!]+))\\n?)");
            Matcher m = p.matcher(s);
            while (m.find()){
                k++;
            }
            oper = "Количество параграфов : ";
        }

        mm.put("res",k);
        mm.put("oper",oper);
        return "Task15/result";
    }
}
