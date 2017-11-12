package poi.validator.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import poi.validator.EqualsPropertyValuesValidator;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {EqualsPropertyValuesValidator.class})
public @interface EqualsPropertyValues {

	String message() default "{error.EqualsPropertyValue}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	String property();

	String comparingProperty();

	@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
	@Retention(RetentionPolicy.RUNTIME)
	@Documented
	public @interface List {
		EqualsPropertyValues[] vakue();
	}

}
