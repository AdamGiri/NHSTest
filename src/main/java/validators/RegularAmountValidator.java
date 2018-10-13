package validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import annotations.ValidRegularAmount;
import enums.Frequency;
import models.RegularAmount;

public class RegularAmountValidator implements ConstraintValidator<ValidRegularAmount, RegularAmount>{

	
	//NB I am assuming a quarter is 13 weeks
	public boolean isValid(RegularAmount value, ConstraintValidatorContext context)
	{
		//invalidate if frequency == month i.e. not a multiple of a week
		if (value.getFrequency() == Frequency.MONTH) return false;
		
		//convert amount to double
		
		double totalAmount = Double.parseDouble(value.getAmount());
		
		//multiply amount by 100 to pence
		
		double totalAmountPence = totalAmount * 100 / new FrequencyToWeekCalculator(value.getFrequency()).calculate();
		
		//valid if %= 0
		
		if (totalAmountPence % 1 == 0) return true;
		
		return false;
	}

}
