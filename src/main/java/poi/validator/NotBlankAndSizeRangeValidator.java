package poi.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;

import poi.validator.annotation.NotBlankAndSizeRange;

public class NotBlankAndSizeRangeValidator implements ConstraintValidator<NotBlankAndSizeRange, String> {

	private NotBlankAndSizeRange constraint;

	@Override
	public void initialize(NotBlankAndSizeRange constraint) {
		this.constraint = constraint;
	}

	@Override
	public boolean isValid(String object, ConstraintValidatorContext context) {

		if (StringUtils.isEmpty(object)) {
			return true;
		}

		// min
		if (object.length() < constraint.min()) {
			return false;
		}
		
		// man
		if (object.length() > constraint.max()) {
			return false;
		}

		return true;
	}

}