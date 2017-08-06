package poi.controller.general;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import poi.constant.UrlConstant;
import poi.domain.service.DaoService;
import poi.dto.general.SessionRegisterDto;
import poi.form.general.AccountCreateForm;

@Transactional
@Controller
public class RegisterController {
	
	@Autowired
	protected DaoService daoService;
	
	@Autowired
	protected SessionRegisterDto sessionRegisterDto;
	
	@RequestMapping(value = UrlConstant.Controller.General.REGISTER, method = RequestMethod.POST)
	public String register() {
		
		return UrlConstant.Page.General.REGISTER;
	}

	@RequestMapping(value = UrlConstant.Controller.General.CONFIRM, method = RequestMethod.POST)
	public String confirm(@ModelAttribute AccountCreateForm accountCreateForm, Model model) {
		
		model.addAttribute("accountCreateForm", accountCreateForm);
		BeanUtils.copyProperties(accountCreateForm, sessionRegisterDto);
		
		return UrlConstant.Page.General.CONFIRM;
	}

	@RequestMapping(value = UrlConstant.Controller.General.CREATE_ACCOUNT, method = RequestMethod.POST)
	public String create() {
		
		daoService.registerUser(sessionRegisterDto);
		return UrlConstant.Page.Member.TOP;
	}
}
