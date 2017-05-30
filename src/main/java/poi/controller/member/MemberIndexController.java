package poi.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("member/poi")
public class MemberIndexController {
    @RequestMapping(method=RequestMethod.POST)
    public String index() {
        return "member/index";
    }
}

