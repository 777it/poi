package poi.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import poi.validator.annotation.UploadFileNotEmpty;

public class UploadFileNotEmptyValidator implements ConstraintValidator<UploadFileNotEmpty, MultipartFile> {

	@Override
	public void initialize(UploadFileNotEmpty constraint) {
	}

	@Override
	public boolean isValid(MultipartFile multipartFile, ConstraintValidatorContext context) {
		if (multipartFile == null || StringUtils.isEmpty(multipartFile.getOriginalFilename())) {
			return true;
		}
		return !multipartFile.isEmpty();
	}
}