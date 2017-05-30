package poi.controller.general;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/poi")
public class GeneralIndexController {
    @RequestMapping(method=RequestMethod.GET)
    public String index() {
        return "general/index";
    }
}

