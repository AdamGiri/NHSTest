# NHSTest

#Background:

This maven project contains an annotation (ValidRegularAmount) and an associated ConstraintValidator (RegularAmountValidator) which are used to validate whether a regular amount value entered by a citizen is a multiple of a whole number of pence when divided to a one week frequency. 

The validation logic is performed in the isValid Method of the RegularAmountValidator. It is immediately rejected if the Frequency on the RegularAmount instance is of a MONTH value. Any other frequency types are passed down the logic of the validation chain.

There are various utilty classes that perform conversions (AmountToWeeklyPenceCalculator and FrequencyToWeekCalculator). These aid in converting a string pound amount input into a pence within a double format. The FrequencyToWeekCalculator calculator is abstracted out to ICalculator interface which returns a generic, this will enable easier future modifications to the code (i.e. if Frequency changes), just create a new calculator implementation.

Floating point is not used as it will introduce errors.

It was assumed (as per the brief) that the amount property of RegularAmount is being validated by some hypothetical annotation.

#Unit tests:

There are numerous tests covering the following constraint:

 1. Whether the amount is a multiple of a whole number of pence when divided to a one week frequency for every Frequency type.
 
Some tests will evalute whether any constraint violation messages (as defined in the ValidRegularAmount message default implementation   method) have returned. This will be an indication of whether the RegularAmount is invalid or not.
 
Other tests evaluate whether the expected violation message matches what is actually returned. 

#Logging

Log4j is used to help logging throughout the project. It's configuration is found under resources in log4j.properties.

