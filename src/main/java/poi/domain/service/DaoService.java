package poi.domain.service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poi.domain.dao.ArticleTDao;
import poi.domain.dao.CategoryTDao;
import poi.domain.dao.UserTDao;
import poi.domain.entity.ArticleT;
import poi.domain.entity.UserT;
import poi.dto.general.SessionRegisterDto;
import poi.dto.member.SessionUserDto;

@Service
public class DaoService {
	
	/** 日付フォーマット */
	public static final String DATE_PATTERN ="yyyy/MM/dd HH:mm:ss";
	
	@Autowired
	protected UserTDao userTDao;
	@Autowired
	protected ArticleTDao articleTDao;
	@Autowired
	protected CategoryTDao categoryTDao;
	@Autowired
	protected SessionUserDto sessionUserDto;
	
	protected UserT userEntity = new UserT();
	
	// ユーザーテーブルに情報を登録する
	public void registerUser(SessionRegisterDto sessionRegisterDto) {
		userEntity.username = sessionRegisterDto.getUsername();
		userEntity.mail = sessionRegisterDto.getMail();
		userEntity.password = sessionRegisterDto.getPassword();
		userEntity.birthday = sessionRegisterDto.getBirthday();
		userEntity.createdAt = LocalDateTime.now();
		userEntity.updatedAt = LocalDateTime.now();
		userTDao.insert(userEntity);
	}
	// ユーザーテーブルから全ての情報を取得する
	public List<UserT> findAll() {
		List<UserT> user = userTDao.selectAll();
		return user;
	}
	// フォームに入力されたユーザーの情報を取得し、セッションにセットする
	public void selectUserAndSetSession(String loginId) {
		userEntity = userTDao.selectByLoginId(loginId);
		sessionUserDto.setId(userEntity.id);
		sessionUserDto.setUsername(userEntity.username);
	}
	
	// ユーザー名で記事の件数を取得
	public int selectArticleCount(String username) {
		int articleCount = articleTDao.selectArticleCountByUsernameAndDeletedAt(username);
		return articleCount;
	}
	// ユーザー名でカテゴリを取得
	public List<String> selectCategory(String username) {
		List<String> categoryList = categoryTDao.selectCategoryByUsernameAndDeletedAt(username);
		return categoryList;
	}
	// ユーザー名とカテゴリとレベルに紐づく記事を取得
	public Map<String, String> selectArticle(String username, String category, String level) {
		
		List<ArticleT> articleList = new LinkedList<>();
		Map<String, String> articleMap = new LinkedHashMap<String, String>();
		
		//カテゴリに紐づく記事を取得
		if (level.isEmpty()) {
			articleList = articleTDao.selectArticleByUsernameAndCategoryAndDeletedAt(username, category);
	    //カテゴリとレベル紐づく記事を取得
		} else {
			int levelInt = Integer.parseInt(level);
			articleList = articleTDao.selectArticleByUsernameAndCategoryAndLevelAndDeletedAt(username, category, levelInt);
		}
		
		// 記事がない場合
		if (articleList.isEmpty()) {
			articleMap.put("noArticle", "記事は見つかりませんでした");
			
			return articleMap;
		// 記事がある場合
		}else {
			String updateDateStr = null;
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_PATTERN);
			for (ArticleT article: articleList) {
				String postNo = "post-" + String.valueOf(article.id);
				updateDateStr = article.updatedAt.format(formatter);
				articleMap.put("postNo", postNo);
				articleMap.put("title", article.title);
				articleMap.put("body", article.body);
				articleMap.put("category", article.category);
				articleMap.put("level", article.level);
				articleMap.put("updateDate", updateDateStr);
			}
			return articleMap;			
		}
	}
}
