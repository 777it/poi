package poi.domain.entity;

import java.time.LocalDateTime;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

@Entity
@Table(name = "user_t")
public class UserT {
	
    /** ID */
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    public Integer id;
	
	/** ユーザー名 */
	@Column(name = "username")
	public String username;
	
	/** メールアドレス */
	@Column(name = "mail")
    public String mail;
    
    /** パスワード */
	@Column(name = "password")
    public String password;
    
    /** パスワード失敗回数 */
	@Column(name = "password_failed_count")
    public Integer passwordFailedCount;

    /** 生年月日 */
	@Column(name = "birthday")
    public String birthday;
    
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
