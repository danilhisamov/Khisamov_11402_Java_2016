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
@RequestMapping("/mult")
public class MultController {
    @RequestMapping(value = "/{num1}/{num2}",method = RequestMethod.GET)
    public String showRes(ModelMap mm, @PathVariable("num1") int num1,@PathVariable("num2") int num2){
        mm.put("res",num1 + " * " + num2 + " = " + num1*num2);
        return "Task14/mult";
    }
}
