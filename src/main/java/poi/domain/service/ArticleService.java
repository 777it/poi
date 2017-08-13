package poi.domain.service;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poi.domain.dao.ArticleTDao;
import poi.domain.dao.CategoryTDao;
import poi.domain.entity.ArticleT;
import poi.dto.member.ArticleTDto;

@Service
public class ArticleService {
	
	@Autowired
	protected ArticleTDao articleTDao;
	@Autowired
	protected CategoryTDao categoryTDao;
	/**
	 * ユーザーエンティティ*/
	protected ArticleT articleEntity = new ArticleT();
	
	/**
	 * ユーザー名で記事の件数を取得
	 * @param username
	 * @return
	 */
	public int selectArticleCount(String username) {
		int articleCount = articleTDao.selectArticleCountByUsernameAndDeletedAt(username);
		return articleCount;
	}
	
	/**
	 * ユーザー名でカテゴリを取得
	 * @param username
	 * @return
	 */
	public List<String> selectCategory(String username) {
		List<String> categoryList = categoryTDao.selectCategoryByUsernameAndDeletedAt(username);
		return categoryList;
	}
	
	/**
	 * ユーザー名とカテゴリとレベルに紐づく記事を取得
	 * @param username
	 * @param category
	 * @param level
	 * @return
	 */
	public List<ArticleT> selectArticle(String username, String category, String level) {
		
		int levelInt = Integer.parseInt(level);
		List<ArticleT> articleList = new LinkedList<>();
		// 全記事を取得
		if (category == "" && levelInt == 0) {
			articleList = articleTDao.selectArticleByUsernameAndDeletedAt(username);
		
		//カテゴリに紐づく記事を取得(レベル未選択)
	    } else if (levelInt == 0) {
			articleList = articleTDao.selectArticleByUsernameAndCategoryAndDeletedAt(username, category);
		//レベルに紐づく記事を取得(カテゴリ未選択)
	    } else if (category == "") {
			articleList = articleTDao.selectArticleByUsernameAndLevelAndDeletedAt(username, levelInt);
	    //カテゴリとレベル紐づく記事を取得
		} else {
			articleList = articleTDao.selectArticleByUsernameAndCategoryAndLevelAndDeletedAt(username, category, levelInt);
		}

		return articleList;			
	}
	
	/**
	 * 記事を新規登録する
	 * @param articleTDto
	 */
	public void registerArticle(ArticleTDto articleTDto) {
		articleEntity.username = articleTDto.username;
		articleEntity.title = articleTDto.title;
		articleEntity.body = articleTDto.body;
		articleEntity.category = articleTDto.category;
		articleEntity.level = articleTDto.level;
		articleEntity.createdAt = LocalDateTime.now();
		articleEntity.updatedAt = LocalDateTime.now();
		int result = articleTDao.insert(articleEntity);
		System.out.println("「article_t」に" + result + "件の記事を登録");
	}
}
