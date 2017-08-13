package poi.controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import poi.constant.UrlConstant;
import poi.controller.BaseController;
import poi.domain.service.ArticleService;
import poi.dto.member.ArticleTDto;
import poi.dto.member.SessionUserDto;
import poi.form.member.ArticleForm;

@Transactional
@Controller
public class WorkController extends BaseController {
	

	@Autowired
	protected ArticleService articleService;
	@Autowired
	protected SessionUserDto sessionUserDto;

	/**
	 * 新規に記事を作成する
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = UrlConstant.Controller.Member.CREATE, method = RequestMethod.POST)
	public String create(@ModelAttribute ArticleForm articleForm, Model model) {
		ArticleTDto articleTDto = new ArticleTDto();
		articleTDto.username = articleForm.getUsername();
		articleTDto.title = articleForm.getTitle();
		articleTDto.body = articleForm.getBody();
		articleTDto.category = articleForm.getCategory();
		articleTDto.level = Integer.parseInt(articleForm.getLevel());

		articleService.registerArticle(articleTDto);
		model.addAttribute("hello", "新規メモ完成！");
		
		return UrlConstant.Page.Member.COMPLETE;
	}
//	@RequestMapping(value = UrlConstant.Controller.Member.SETTING, method = RequestMethod.POST)
//	public String setting(Model model) {
//		model.addAttribute("hello", "ユーザー設定を変更しました!");
//		return UrlConstant.Page.Member.COMPLETE;
//	}
//	@RequestMapping(value = UrlConstant.Controller.Member.UPDATE, method = RequestMethod.POST)
//	public String update(Model model) {
//		model.addAttribute("hello", "メモを更新！");
//		return UrlConstant.Page.Member.COMPLETE;
//	}
//
//	@RequestMapping(value = UrlConstant.Controller.Member.DELETE, method = RequestMethod.POST)
//	public String delete(Model model) {
//		model.addAttribute("hello", "メモを削除!");
//		return UrlConstant.Page.Member.COMPLETE;
//	}

}
