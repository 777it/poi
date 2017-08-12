package poi.form.member;

import java.io.Serializable;

public class ConditionsForm implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/** カテゴリ */
	private String category;

	/** レベル */
	private String level;

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