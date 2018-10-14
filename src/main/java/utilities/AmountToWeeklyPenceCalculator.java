package utilities;

//1) parse string to double
//2) convert pounds to pence
//3) calculate weekly amount
public class AmountToWeeklyPenceCalculator {
	
	private ICalculator<Integer> calculator;
	private String amount;
	
	public AmountToWeeklyPenceCalculator(ICalculator<Integer> calculator, String amount) {
		this.calculator = calculator;
		this.amount = amount;
	}
	
	private double parseStringToDouble()
	{
		return Double.parseDouble(amount);
	}
	
	private double convertAmountToPence(double amount)
	{
		return amount * 100;
	}
	
	public double calculateWeeklyAmountInDoubleFormat()
	{
		return convertAmountToPence(parseStringToDouble()) / calculator.calculate();
	}
	
	
	
}
