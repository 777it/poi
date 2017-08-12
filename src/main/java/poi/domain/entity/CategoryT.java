package poi.domain.entity;

import java.time.LocalDateTime;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

@Entity
@Table(name = "category_t")
public class CategoryT {
	
    /** ID */
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    public Integer id;
	
	/** ユーザー名 */
	@Column(name = "username")
	public String username;
	
	/** カテゴリ */
	@Column(name = "category")
    public String category;
    
    /** 作成日時 */
	@Column(name = "created_at")
    public LocalDateTime createdAt;

    /** 更新日時 */
	@Column(name = "updated_at")
    public LocalDateTime updatedAt;

    /** 削除日時 */
	@Column(name = "deleted_at")
    public LocalDateTime deletedAt;
}
