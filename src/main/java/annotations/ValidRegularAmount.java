package annotations;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import validators.RegularAmountValidator;

@Documented
@Retention(RUNTIME)
@Constraint(validatedBy = RegularAmountValidator.class)
@Target(TYPE)
public @interface ValidRegularAmount {
	
	String message() default "Amount must be a multiple of a whole number of pence " +
							   "when divided to a one week  frequency.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
