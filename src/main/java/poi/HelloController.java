package poi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/poi")
public class HelloController 
{
    @RequestMapping(method=RequestMethod.GET)
    public String home() {
        return "hello";
    }
}
