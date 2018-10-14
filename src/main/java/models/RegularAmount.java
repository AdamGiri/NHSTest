package models;

import javax.validation.constraints.NotNull;


import annotations.ValidRegularAmount;
import enums.Frequency;

@ValidRegularAmount
public class RegularAmount {

	@NotNull
	private Frequency frequency;
	
	@NotNull
	private String amount;
	
	public RegularAmount(Frequency frequency, String amount) {
		this.frequency = frequency;
		this.amount = amount;
	}

	public Frequency getFrequency() {
		return frequency;
	}

	public void setFrequency(Frequency frequency) {
		this.frequency = frequency;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

}
