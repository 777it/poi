package poi.dto.general;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserDto implements Serializable {

	private static final long serialVersionUID = 1L;

    /** ID */
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/** ユーザー名 */
	private String username;
	
	/** メールアドレス */
	private String mail;
    
    /** パスワード */
	private String password;
    
    /** パスワード失敗回数 */
	private Integer passwordFailedCount;

    /** 生年月日 */
	private String birthday;
    
    /** 作成日時 */
	private LocalDateTime createdAt;

    /** 更新日時 */
	private LocalDateTime updatedAt;

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getPasswordFailedCount() {
		return passwordFailedCount;
	}

	public void setPasswordFailedCount(Integer passwordFailedCount) {
		this.passwordFailedCount = passwordFailedCount;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public LocalDateTime getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(LocalDateTime deletedAt) {
		this.deletedAt = deletedAt;
	}

	/** 削除日時 */
	private LocalDateTime deletedAt;
	
}
