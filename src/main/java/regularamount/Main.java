package regularamount;

import enums.Frequency;
import models.RegularAmount;
import utilities.FrequencyToWeekCalculator;

public class Main {

	public static void main(String[] args) {
		
		RegularAmount regularAmount = new RegularAmount(Frequency.FOUR_WEEK, "30.7");
		
		
	if (regularAmount.getFrequency() == Frequency.MONTH) System.out.println("false");
		
		//convert amount to double
		
		double totalAmount = Double.parseDouble(regularAmount.getAmount());
		
		//multiply amount by 100 to pence
		
		double totalAmountPence = totalAmount * 100 / new FrequencyToWeekCalculator(regularAmount.getFrequency()).calculate();
		
		//valid if %= 0
		
		if (totalAmountPence % 1 == 0) System.out.println("true");
		
		System.out.println("false");
		
	}
	
	

}
