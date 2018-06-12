package com.akshay.department;

import java.math.BigDecimal;

public class Developer extends Employee {
	private static final BigDecimal DEVELOPER_ALLOCATION_AMOUNT = new BigDecimal(1000);

	@Override
	public BigDecimal getAllocationAmount() {
		return DEVELOPER_ALLOCATION_AMOUNT;
	}

	@Override
	public EmployeeType getEmployeeType() {
		return EmployeeType.DEVELOPER;
	}

}
