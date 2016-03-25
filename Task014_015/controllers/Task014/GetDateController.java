package controllers.Task014;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

/**
 * @author Danil Khisamov
 *         11-402
 */
@Controller
@RequestMapping("/getdate")
public class GetDateController {
    @RequestMapping(method = RequestMethod.GET)
    public String getDate(ModelMap mm){
        mm.put("date",(new Date()).toString());
        return "Task14/date";
    }
}
