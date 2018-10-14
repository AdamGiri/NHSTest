package utilities;

import org.apache.log4j.Logger;

import enums.Frequency;

public class FrequencyToWeekCalculator implements ICalculator<Integer> {
	
	private Frequency frequency;
	final static Logger logger = Logger.getLogger(FrequencyToWeekCalculator.class);

	public FrequencyToWeekCalculator(Frequency frequency)
	{
		this.frequency = frequency;
	}
	
	
	public Integer calculate()
	{
		switch (frequency) {
			case WEEK:
				logger.debug("Returning 1 week for WEEK frequency");
				return 1;
			case TWO_WEEK:
				logger.debug("Returning 2 weeks for TWO_WEEK frequency");
				return 2;
			case FOUR_WEEK:
				logger.debug("Returning 4 weeks for FOUR_WEEK frequency");
				return 4;
			case QUARTER:
				logger.debug("Returning 13 weeks for QUARTER frequency");
				return 13;
			case YEAR:
				logger.debug("Returning 52 weeks for YEAR frequency");
				return 52;
		    default:
			    break;	
		}
		
		return 0;
	}
	
}
