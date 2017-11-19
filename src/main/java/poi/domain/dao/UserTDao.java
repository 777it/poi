package poi.domain.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;

import poi.domain.entity.UserT;
import poi.util.doma.DataSourceConfiguration;


@DataSourceConfiguration
@Dao
public interface UserTDao {
    @Select
    List<UserT> selectAll();
    
	@Insert(exclude = {"passwordFailedCount"})
	int insert(UserT entity);
	
	@Select
	UserT selectByLoginIdAndPasswordAndDeletedAt(final String loginId, final String password);
	
	@Select
	String selectByUsername(final String username);
	
	@Select
	UserT selectByLoginId(final String loginId);
	
	@Select
	UserT selectCategoryByUsernameAndDeletedAt(final String username);
	
	@Select
	UserT selectArticleByUsernameAndCategoryAndDeletedAt(final String username, final String category);
	
	@Update
	int update(UserT entity);
}
