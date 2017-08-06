package poi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import poi.constant.UrlConstant;

@Controller
public class ErrorController {
 
	@RequestMapping(value = UrlConstant.Controller.Error.NOT_FOUND)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String notFound() {
		return UrlConstant.Page.Error.NOT_FOUND;
	}
}