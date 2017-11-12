package poi.domain.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;

import poi.domain.entity.ArticleT;
import poi.domain.entity.CategoryT;
import poi.util.doma.DataSourceConfiguration;


@DataSourceConfiguration
@Dao
public interface CategoryTDao {
    @Select
    List<CategoryT> selectAll();
	
	@Select
	List<CategoryT> selectCategoryByUsernameAndDeletedAt(final String username);
	
	@Insert
	int insert(CategoryT entity);
	
	@Update(sqlFile = true)
	int update(CategoryT entity, int id);
	
	@Delete(sqlFile = true)
	int delete(int id);
}
