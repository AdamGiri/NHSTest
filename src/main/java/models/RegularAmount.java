package models;

import javax.validation.constraints.NotNull;

import annotations.ValidRegularAmount;
import enums.Frequency;

@ValidRegularAmount
public class RegularAmount {

	@NotNull
	private Frequency frequency;
	//TODO create validator to format "##.#"
	@NotNull
	private String amount;

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
