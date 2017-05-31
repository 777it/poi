package poi.controller.general;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/poi")
public class GeneralIndexController {
    @RequestMapping(method=RequestMethod.GET)
    public String index(Model model) {
    	model.addAttribute("hello", "Hello World!");
        return "general/index";
    }
}

