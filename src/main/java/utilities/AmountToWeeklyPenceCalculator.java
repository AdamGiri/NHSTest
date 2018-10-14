package utilities;

import org.apache.log4j.Logger;



//1) parse string to double
//2) convert pounds to pence
//3) calculate weekly amount
public class AmountToWeeklyPenceCalculator {
	
	private ICalculator<Integer> calculator;
	private String amount;
	final static Logger logger = Logger.getLogger(AmountToWeeklyPenceCalculator.class);
	
	public AmountToWeeklyPenceCalculator(ICalculator<Integer> calculator, String amount) {
		this.calculator = calculator;
		this.amount = amount;
	}
	
	private double parseStringToDouble()
	{
		try 
		{
			logger.debug("Converting string amount to a double");
			return Double.parseDouble(amount);
		}
		catch (NumberFormatException e)
		{
			logger.warn("Amount can't be parsed to a double, it is of an incorrect string format.", e);
		}
		
		return 0; 
	}
	
	private double convertAmountToPence(double amount)
	{
		logger.debug("Converting amount in pounds to pence.");
		return amount * 100;
	}
	
	public double calculateWeeklyAmountInDoubleFormat()
	{
		logger.debug("Calculating weekly amount in double format.");
		return convertAmountToPence(parseStringToDouble()) / calculator.calculate();
	}
	
	
	
}
