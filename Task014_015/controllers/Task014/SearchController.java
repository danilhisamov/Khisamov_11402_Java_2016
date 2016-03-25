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
@RequestMapping("/search")
public class SearchController {
    @RequestMapping(value = "/{prov}",method = RequestMethod.GET)
    public String search(ModelMap mm, @PathVariable("prov") String prov){
        String hProv = "";
        String searchParam = "";
        if ("baidu".equals(prov)){
            hProv = "https://www.baidu.com/s";
            searchParam = "wd";
        }else if ("yahoo".equals(prov)){
            hProv = "https://search.yahoo.com/search";
            searchParam = "p";
        }else if ("bing".equals(prov)){
            hProv = "http://www.bing.com/search";
            searchParam = "q";
        }else if ("aol".equals(prov)){
            hProv = "http://search.aol.com/aol/search";
            searchParam = "q";
        }
        mm.put("hProv",hProv);
        mm.put("searchP",searchParam);
        return "Task14/search";
    }
}
