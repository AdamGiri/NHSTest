package validators;

import enums.Frequency;

public class FrequencyToWeekCalculator {
	
	private Frequency frequency;

	public FrequencyToWeekCalculator(Frequency frequency)
	{
		this.frequency = frequency;
	}
	
	
	public int calculate()
	{
		switch (frequency) {
			case WEEK:
				return 1;
			case TWO_WEEK:
				return 2;
			case FOUR_WEEK:
				return 4;
			case QUARTER:
				return 13;
			case YEAR:
				return 52;
		    default:
			    break;	
		}
		
		return 0;
	}
	
}
