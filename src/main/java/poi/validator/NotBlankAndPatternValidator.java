package poi.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;

import poi.validator.annotation.NotBlankAndPattern;

public class NotBlankAndPatternValidator implements ConstraintValidator<NotBlankAndPattern, String> {

	private NotBlankAndPattern constraint;

	@Override
	public void initialize(NotBlankAndPattern constraint) {
		this.constraint = constraint;
	}

	@Override
	public boolean isValid(String object, ConstraintValidatorContext context) {

		if (StringUtils.isEmpty(object)) {
			return true;
		}
		if (StringUtils.isEmpty(constraint.regexp())) {
			return true;
		}
		return patternMatching(constraint.regexp(), object);
	}

	private boolean patternMatching(String patternStr, String targetStr) {
		Pattern pattern = Pattern.compile(patternStr);
		Matcher matcher = pattern.matcher(targetStr);
		return matcher.matches();
	}
}