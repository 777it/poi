package poi.controller.general;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {
    @RequestMapping(value = "/general/register", method=RequestMethod.POST)
    public String register() {
        return "general/register";
    }
    @RequestMapping(value = "/general/confirm", method=RequestMethod.POST)
    public String confirm() {
        return "general/confirm";
    }
    @RequestMapping(value = "/general/create", method=RequestMethod.POST)
    public String create() {
        return "member/index";
    }
}
