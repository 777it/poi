package poi.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.util.ObjectUtils;

import poi.validator.annotation.EqualsPropertyValues;



public class EqualsPropertyValuesValidator implements ConstraintValidator<EqualsPropertyValues, Object> {

	private String property;
	private String comparingProperty;
	private String message;

	@Override
	public void initialize(EqualsPropertyValues constraintAnnotation) {
		this.property = constraintAnnotation.property();
		this.comparingProperty = constraintAnnotation.comparingProperty();
		this.message = constraintAnnotation.message();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {

		BeanWrapper beanWeapper = new BeanWrapperImpl(value);
		Object propertyValue = beanWeapper.getPropertyValue(property);
		Object comparingPropertyValue = beanWeapper.getPropertyValue(comparingProperty);
		boolean matched = ObjectUtils.nullSafeEquals(propertyValue, comparingPropertyValue);

		if (matched) {
			return true;
		} else {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(message).addPropertyNode(property).addConstraintViolation();
			return false;
		}

	}
}