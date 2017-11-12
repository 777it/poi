package poi.form.member;

import java.io.Serializable;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import poi.validator.seq.First;
import poi.validator.seq.Second;

public class LoginForm implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/** ユーザー名 */
	@NotBlank(message = "{error.NotBlank}", groups = First.class)
	@Size(max = 20, message = "{error.Size}", groups = Second.class)
	private String loginId;

	/** パスワード */
	@NotBlank(message = "{error.NotBlank}", groups = First.class)
	@Size(max = 20, message = "{error.Size}", groups = Second.class)
	private String password;
	
	/** 認証エラーメッセージ出力用 */
	private String auth;

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}