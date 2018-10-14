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
		if (isFrequencyMonth(value.getFrequency())) return false;
		
		//calculate if amount is a multiple of whole pence after dividing to weekly value
		if (isAmountAMultipleOfWholePence(generateAmountToWeeklyPenceCalculator(value))) return true;
		
		return false;
	}
	
	private boolean isFrequencyMonth(Frequency frequency)
	{
		if (frequency == Frequency.MONTH)
		{
			logger.info("Frequency is one month, therefore it is invalid as monthly incomes will not divide to a whole weekly value. ");
			return true;
		}
		
		return false;
	}
	
	private AmountToWeeklyPenceCalculator generateAmountToWeeklyPenceCalculator(RegularAmount value)
	{
		logger.debug("Converting the amount to a weekly pence amount in double format.");
		return new AmountToWeeklyPenceCalculator(new FrequencyToWeekCalculator(value.getFrequency()), value.getAmount());
	}
	
	private boolean isAmountAMultipleOfWholePence(AmountToWeeklyPenceCalculator calculator)
	{
		//valid if %= 0
		if (calculator.calculateWeeklyAmountInDoubleFormat() % 1 == 0) {
			logger.info("Amount is a multiple of a whole number of pence when divided to a one week frequency");
			return true;
		}
		
		logger.info("Amount is not a multiple of a whole number of pence when divided to a one week frequency");
		return false;
	}

}
