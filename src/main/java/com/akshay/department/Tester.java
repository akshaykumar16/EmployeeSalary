package com.akshay.department;

import java.math.BigDecimal;

public class Tester extends Employee {
	private static final BigDecimal TESTER_ALLOCATION_AMOUNT = new BigDecimal(500);

	@Override
	public BigDecimal getAllocationAmount() {
		return TESTER_ALLOCATION_AMOUNT;
	}

	@Override
	public EmployeeType getEmployeeType() {
		return EmployeeType.TESTER;
	}

}
