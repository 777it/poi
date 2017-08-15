package poi.form.member;

import java.io.Serializable;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class ArticleForm implements Serializable {
	private static final long serialVersionUID = 1L;

	/** ユーザー名 */
	private String username;
	
	/** タイトル */
	@NotBlank(message = "{error.NotBlank}")
	@Size(max = 20, message = "{error.Size}")
	private String title;
	
	/** 本文 */
	@NotBlank(message = "{error.NotBlank}")
	private String body;

	/** カテゴリ */
	private String category;
	
	/** レベル */
	private String level;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}