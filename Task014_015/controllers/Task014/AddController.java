package controllers.Task014;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Danil Khisamov
 *         11-402
 */
@Controller
@RequestMapping("/add")
public class AddController {
    @RequestMapping(value = "/{num1}/{num2}",method = RequestMethod.GET)
    public String showRes(ModelMap mm,@PathVariable("num1") String num1,@PathVariable("num2") String num2){
        int res = Integer.parseInt(num1) + Integer.parseInt(num2);
        mm.put("res",num1 + " + " + num2 + " = " + res);
        return "Task14/add";
    }
}
