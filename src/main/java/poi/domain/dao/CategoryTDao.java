package poi.domain.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import poi.domain.entity.CategoryT;
import poi.util.doma.DataSourceConfiguration;


@DataSourceConfiguration
@Dao
public interface CategoryTDao {
    @Select
    List<CategoryT> selectAll();
	
	@Select
	List<String> selectCategoryByUsernameAndDeletedAt(final String username);

}
