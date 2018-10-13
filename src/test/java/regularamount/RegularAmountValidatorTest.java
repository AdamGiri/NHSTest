package regularamount;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.Test;

import enums.Frequency;
import models.RegularAmount;

public class RegularAmountValidatorTest {
	
	private static Validator validator;
	private String violationMessage = "Amount must be a multiple of a whole number of pence when divided to a one week  frequency.";
	
	@Before
	public void setUp()
	{
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
	}
	
	@Test
	public void oneWeekFrequencyWithWholePenceNumberAmountShouldReturnNoViolations()
	{
		RegularAmount regularAmount = new RegularAmount(Frequency.WEEK, "10.0");
		Set<ConstraintViolation<RegularAmount>> violations = validator.validate(regularAmount);
		assertEquals(0, violations.size());
	}
	
	@Test
	public void oneWeekFrequencyWithNonWholePenceNumberAmountShouldReturnAViolationMessage()
	{
		RegularAmount regularAmount = new RegularAmount(Frequency.WEEK, "10.152");
		Set<ConstraintViolation<RegularAmount>> violations = validator.validate(regularAmount);
		assertEquals(violationMessage, violations.iterator().next().getMessage());
	}
	
	@Test
	public void twoWeekFrequencyWithWholePenceNumberAmountShouldReturnNoViolations()
	{
		RegularAmount regularAmount = new RegularAmount(Frequency.TWO_WEEK, "50.0");
		Set<ConstraintViolation<RegularAmount>> violations = validator.validate(regularAmount);
		assertEquals(0, violations.size());
	}
	
	@Test
	public void twoWeekFrequencyWithNonWholePenceNumberAmountShouldReturnAViolationMessage()
	{
		RegularAmount regularAmount = new RegularAmount(Frequency.TWO_WEEK, "50.389");
		Set<ConstraintViolation<RegularAmount>> violations = validator.validate(regularAmount);
		assertEquals(violationMessage, violations.iterator().next().getMessage());
	}
	
	
	
}
