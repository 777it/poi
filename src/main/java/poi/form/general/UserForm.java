package poi.form.general;

import java.io.Serializable;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class UserForm implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/** ユーザー名 */
	@NotBlank(message = "{error.NotBlank}")
	@Size(max = 20, message = "{error.Size}")
	private String username;
	
	/** メール */
	@NotBlank(message = "{error.NotBlank}")
	@Size(max = 20, message = "{error.Size}")
	private String mail;

	/** パスワード */
	@NotBlank(message = "{error.NotBlank}")
	@Size(max = 20, message = "{error.Size}")
	private String password;
	
	/** 生年月日 */
	private String birthday;

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

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}