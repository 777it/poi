package poi.domain.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;

import poi.domain.entity.UserT;
import poi.util.doma.DataSourceConfiguration;


@DataSourceConfiguration
@Dao
public interface UserTDao {
    @Select
    List<UserT> selectAll();
    
	@Insert(exclude = {"passwordFailedCount"})
	int insert(UserT entity);
}
