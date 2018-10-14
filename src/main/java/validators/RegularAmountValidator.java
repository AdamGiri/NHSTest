package validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import annotations.ValidRegularAmount;
import enums.Frequency;
import models.RegularAmount;
import utilities.AmountToWeeklyPenceCalculator;
import utilities.FrequencyToWeekCalculator;

public class RegularAmountValidator implements ConstraintValidator<ValidRegularAmount, RegularAmount>{

	
	//NB I am assuming a quarter is 13 weeks
	public boolean isValid(RegularAmount value, ConstraintValidatorContext context)
	{
		//invalidate if frequency == month i.e. not a multiple of a week
		if (value.getFrequency() == Frequency.MONTH) return false;
		
		AmountToWeeklyPenceCalculator amountToWeeklyPenceCalculator = new AmountToWeeklyPenceCalculator(new FrequencyToWeekCalculator(value.getFrequency()), value.getAmount());
		
		//valid if %= 0
		
		if (amountToWeeklyPenceCalculator.calculateWeeklyAmountInDoubleFormat() % 1 == 0) return true;
		
		return false;
	}

}
