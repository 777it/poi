package poi.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class KnowledgeController {
    @RequestMapping(value = "/member/create", method=RequestMethod.GET)
    public String displayCreate() {
        return "member/create";
    }
    @RequestMapping(value = "/member/update", method=RequestMethod.GET)
    public String displayUpdate() {
        return "member/update";
    }
    @RequestMapping(value = "/member/delete", method=RequestMethod.GET)
    public String displayDelete() {
        return "member/delete";
    }
    @RequestMapping(value = "/member/search", method=RequestMethod.POST)
    public String search(Model model) {
    	model.addAttribute("hello", "検索結果を表示！");
        return "member/search";
    }
    @RequestMapping(value = "/member/create", method=RequestMethod.POST)
    public String create(Model model) {
    	model.addAttribute("hello", "新規メモ完成！");
        return "member/complete";
    }
    @RequestMapping(value = "/member/update", method=RequestMethod.POST)
    public String update(Model model) {
    	model.addAttribute("hello", "メモを更新！");
        return "member/complete";
    }
    @RequestMapping(value = "/member/delete", method=RequestMethod.POST)
    public String delete(Model model) {
    	model.addAttribute("hello", "メモを削除!");
        return "member/complete";
    }
}

