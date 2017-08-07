package poi.controller.general;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import poi.constant.UrlConstant;
import poi.controller.BaseController;

@Controller
public class GeneralIndexController extends BaseController {
	@RequestMapping(value = UrlConstant.Controller.General.ROOT, method = RequestMethod.GET)
	public String index() {
		return UrlConstant.Page.General.INDEX;
	}
}
