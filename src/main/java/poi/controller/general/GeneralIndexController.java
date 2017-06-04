package poi.controller.general;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import poi.constant.UrlConstant;

@Controller
public class GeneralIndexController {
    @RequestMapping(value = UrlConstant.Controller.General.ROOT, method=RequestMethod.GET)
    public String index(Model model) {
    	model.addAttribute("hello", "Hello World!");
        return UrlConstant.Page.General.INDEX;
    }
}

