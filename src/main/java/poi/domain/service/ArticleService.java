package poi.domain.service;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poi.domain.dao.ArticleTDao;
import poi.domain.dao.CategoryTDao;
import poi.domain.entity.ArticleT;
import poi.domain.entity.CategoryT;
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
	public List<CategoryT> selectCategory(String username) {
		List<CategoryT> categoryList = categoryTDao.selectCategoryByUsernameAndDeletedAt(username);
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
		
		List<ArticleT> articleList = new LinkedList<>();
		// 全記事を取得
		if (category == "" && level == "") {
			articleList = articleTDao.selectArticleByUsernameAndDeletedAt(username);
		
		//カテゴリに紐づく記事を取得(レベル未選択)
	    } else if (level == "") {
			articleList = articleTDao.selectArticleByUsernameAndCategoryAndDeletedAt(username, category);
		//レベルに紐づく記事を取得(カテゴリ未選択)
	    } else if (category == "") {
			articleList = articleTDao.selectArticleByUsernameAndLevelAndDeletedAt(username, Integer.parseInt(level));
	    //カテゴリとレベル紐づく記事を取得
		} else {
			articleList = articleTDao.selectArticleByUsernameAndCategoryAndLevelAndDeletedAt(username, category, Integer.parseInt(level));
		}

		return articleList;			
	}
	
	/**
	 * 選択された記事を取得
	 * 
	 * @param articleId
	 * @return
	 */
	public ArticleT selectArticleByArticleId(String articleId) {
		int articleIdInt = Integer.parseInt(articleId);
		ArticleT article = new ArticleT();
		article = articleTDao.selectArticleByArticleId(articleIdInt);
		return article;
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
	
	/**
	 * 記事を編集する
	 * @param articleTDto
	 * @param articleId
	 */
	public void updateArticle(ArticleTDto articleTDto, String articleId) {
		int articleIdInt = Integer.parseInt(articleId);
		articleEntity.title = articleTDto.title;
		articleEntity.body = articleTDto.body;
		articleEntity.category = articleTDto.category;
		articleEntity.level = articleTDto.level;
		int result = articleTDao.update(articleEntity, articleIdInt);
		System.out.println("「article_t」の" + result + "件の記事を更新");	
	}
	
	/**
	 * 記事を削除する
	 * @param articleId
	 */
	public void deleteArticle(String articleId) {
		int articleIdInt = Integer.parseInt(articleId);
		int result = articleTDao.delete(articleIdInt);
		System.out.println("「article_t」の" + result + "件の記事を削除");
	}
}
