package regularamount;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidationException;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.Test;

import enums.Frequency;
import models.RegularAmount;

public class RegularAmountValidatorTest {
	
	private static Validator validator;
	private String multipleViolationMessage = "Amount must be a multiple of a whole number of pence when divided to a one week  frequency.";
	
	@Before
	public void setUp()
	{
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
	}
	
	/*** Tests below test to see if the amount is a multiple of a whole number of pence when divided to a one week  frequency ***/
	
	@Test
	public void oneWeekFrequency_WithWholePenceNumberAmount_AfterBeingDividedToOneWeek_ShouldReturnNoViolations()
	{
		RegularAmount regularAmount = new RegularAmount(Frequency.WEEK, "10.0");
		assertEquals(0, getViolations(regularAmount).size());
	}
	
	@Test
	public void oneWeekFrequency_WithNonWholePenceNumberAmount_AfterBeingDividedToOneWeek_ShouldReturnAViolationMessage()
	{
		RegularAmount regularAmount = new RegularAmount(Frequency.WEEK, "10.152");
		assertEquals(multipleViolationMessage, getViolations(regularAmount).iterator().next().getMessage());
	}
	
	@Test
	public void twoWeekFrequency_WithWholePenceNumberAmount_AfterBeingDividedToOneWeek_ShouldReturnNoViolations()
	{
		RegularAmount regularAmount = new RegularAmount(Frequency.TWO_WEEK, "50.0");
		assertEquals(0, getViolations(regularAmount).size());
	}
	
	@Test
	public void twoWeekFrequency_WithNonWholePenceNumberAmount_AfterBeingDividedToOneWeek_ShouldReturnAViolationMessage()
	{
		RegularAmount regularAmount = new RegularAmount(Frequency.TWO_WEEK, "50.364");
		assertEquals(multipleViolationMessage, getViolations(regularAmount).iterator().next().getMessage());
	}
	
	@Test
	public void fourWeekFrequency_WithWholePenceNumberAmount_AfterBeingDividedToOneWeek_ShouldReturnNoViolations()
	{
		RegularAmount regularAmount = new RegularAmount(Frequency.FOUR_WEEK, "40");
		assertEquals(0, getViolations(regularAmount).size());
	}
	
	@Test
	public void fourWeekFrequency_WithNonWholePenceNumberAmount_AfterBeingDividedToOneWeek_ShouldReturnAViolationMessage()
	{
		RegularAmount regularAmount = new RegularAmount(Frequency.FOUR_WEEK, "30.7");
		assertEquals(multipleViolationMessage, getViolations(regularAmount).iterator().next().getMessage());
	}
	
	@Test
	public void monthFrequency_ShouldReturnAViolationMessage()
	{
		RegularAmount regularAmount = new RegularAmount(Frequency.MONTH, "40");
		assertEquals(multipleViolationMessage,  getViolations(regularAmount).iterator().next().getMessage());
	}
	
	@Test
	public void quarterFrequency_WithWholePenceNumberAmount_AfterBeingDividedToOneWeek_ShouldReturnNoViolations()
	{
		RegularAmount regularAmount = new RegularAmount(Frequency.QUARTER, "143");
		assertEquals(0, getViolations(regularAmount).size());
	}
	
	@Test
	public void quarterFrequency_WithNonWholePenceNumberAmount_AfterBeingDividedToOneWeek_ShouldReturnAViolationMessage()
	{
		RegularAmount regularAmount = new RegularAmount(Frequency.QUARTER, "145.67");
		assertEquals(multipleViolationMessage, getViolations(regularAmount).iterator().next().getMessage());
	}
	
	@Test
	public void yearFrequency_WithWholePenceNumberAmount_AfterBeingDividedToOneWeek_ShouldReturnNoViolations()
	{
		RegularAmount regularAmount = new RegularAmount(Frequency.YEAR, "390");
		assertEquals(0, getViolations(regularAmount).size());
	}
	
	@Test
	public void yearFrequency_WithNonWholePenceNumberAmount_AfterBeingDividedToOneWeek_ShouldReturnAViolationMessage()
	{
		RegularAmount regularAmount = new RegularAmount(Frequency.YEAR, "370");
		assertEquals(multipleViolationMessage, getViolations(regularAmount).iterator().next().getMessage());
	}
	
	
	
	
	private Set<ConstraintViolation<RegularAmount>> getViolations(RegularAmount regularAmount)
	{
		return validator.validate(regularAmount);
	}
	
	
}
