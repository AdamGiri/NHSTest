package validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import annotations.ValidRegularAmount;
import models.RegularAmount;

public class RegularAmountValidator implements ConstraintValidator<ValidRegularAmount, RegularAmount>{

	public boolean isValid(RegularAmount value, ConstraintValidatorContext context) {
		
		return false;
	}

}
