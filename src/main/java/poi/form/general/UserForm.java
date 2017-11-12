package poi.form.general;

import java.io.Serializable;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import poi.validator.annotation.EqualsPropertyValues;
import poi.validator.seq.First;
import poi.validator.seq.Second;
import poi.validator.seq.Third;

@EqualsPropertyValues(property="password", comparingProperty="reEnteredPassword", groups = Third.class)
public class UserForm implements Serializable {
	private static final long serialVersionUID = 1L;

	/** ユーザー名 */
	@NotBlank(message = "{error.NotBlank}", groups = First.class)
	@Pattern(regexp="[a-zA-Z0-9]*", message = "{error.Pattern.Alphabet}", groups = Second.class)
	@Size(max = 20, message = "{error.Size}", groups = Second.class)
	private String username;

	/** メール */
	@NotBlank(message = "{error.NotBlank}", groups = First.class)
	@Size(max = 20, message = "{error.Size}", groups = Second.class)
	private String mail;

	/** パスワード */
	@NotBlank(message = "{error.NotBlank}", groups = First.class)
	@Size(min = 4, max = 20, message = "{error.SizeRange}", groups = Second.class)
	private String password;

	/** パスワード確認 */
	private String reEnteredPassword;
	
	/** 生年月日(年) */
	@Size(max = 4, message = "{error.Pattern.Format.date}", groups = Second.class)
	private String Year;
	
	/** 生年月日(月) */
	@Size(max = 2, message = "{error.Pattern.Format.date}", groups = Second.class)
	private String Month;
	
	/** 生年月日(日) */
	@Size(max = 2, message = "{error.Pattern.Format.date}", groups = Second.class)
	private String Day;

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

	public String getYear() {
		return Year;
	}

	public void setYear(String year) {
		Year = year;
	}

	public String getMonth() {
		return Month;
	}

	public void setMonth(String month) {
		Month = month;
	}

	public String getDay() {
		return Day;
	}

	public void setDay(String day) {
		Day = day;
	}

	public String getReEnteredPassword() {
		return reEnteredPassword;
	}

	public void setReEnteredPassword(String reEnteredPassword) {
		this.reEnteredPassword = reEnteredPassword;
	}

}