package poi.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
    @RequestMapping(value = "/member/login", method=RequestMethod.POST)
    public String login() {
        return "member/login";
    }
    @RequestMapping(value = "/member/logout", method=RequestMethod.POST)
    public String logout() {
        return "general/index";
    }
}
