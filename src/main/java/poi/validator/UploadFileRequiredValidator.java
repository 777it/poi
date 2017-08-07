package poi.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import poi.validator.annotation.UploadFileRequired;

public class UploadFileRequiredValidator implements ConstraintValidator<UploadFileRequired, MultipartFile> {

	@Override
	public void initialize(UploadFileRequired constraint) {
	}

	@Override
	public boolean isValid(MultipartFile multipartFile, ConstraintValidatorContext context) {
		return multipartFile != null && StringUtils.isNotEmpty(multipartFile.getOriginalFilename());
	}

}