package validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.log4j.Logger;

import annotations.ValidRegularAmount;
import enums.Frequency;
import models.RegularAmount;
import utilities.AmountToWeeklyPenceCalculator;
import utilities.FrequencyToWeekCalculator;

public class RegularAmountValidator implements ConstraintValidator<ValidRegularAmount, RegularAmount>{

	final static Logger logger = Logger.getLogger(RegularAmountValidator.class);
	
	//NB I am assuming a quarter is 13 weeks
	public boolean isValid(RegularAmount value, ConstraintValidatorContext context)
	{
		//invalidate if frequency == month i.e. not a multiple of a week
		if (value.getFrequency() == Frequency.MONTH)
		{
			logger.info("Frequency is one month, therefore it is invalid as monthly incomes will not divide to a whole weekly value. ");
			return false;
		}
		
		logger.debug("Converting the amount to a weekly pence amount in double format.");
		AmountToWeeklyPenceCalculator amountToWeeklyPenceCalculator = new AmountToWeeklyPenceCalculator(new FrequencyToWeekCalculator(value.getFrequency()), value.getAmount());
		
		//valid if %= 0
		
		
		if (amountToWeeklyPenceCalculator.calculateWeeklyAmountInDoubleFormat() % 1 == 0) {
			logger.info("Amount is a multiple of a whole number of pence when divided to a one week frequency");
			return true;
		}
		
		logger.info("Amount is not a multiple of a whole number of pence when divided to a one week frequency");
		return false;
	}

}
