package poi.domain.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;

import poi.domain.entity.ArticleT;
import poi.util.doma.DataSourceConfiguration;


@DataSourceConfiguration
@Dao
public interface ArticleTDao {
    @Select
    List<ArticleT> selectAll();
	
	@Select
	int selectArticleCountByUsernameAndDeletedAt(final String username);
	
	@Select
	List<ArticleT> selectArticleByUsernameAndDeletedAt(final String username);

	@Select
	List<ArticleT> selectArticleByUsernameAndCategoryAndDeletedAt(final String username, String category);

	@Select
	List<ArticleT> selectArticleByUsernameAndLevelAndDeletedAt(final String username, int level);
	
	@Select
	List<ArticleT> selectArticleByUsernameAndCategoryAndLevelAndDeletedAt(final String username, String category, int level);

	@Insert
	int insert(ArticleT entity);
}
