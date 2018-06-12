package com.akshay.department;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Manager extends Employee {
	private List<Employee> reportingEmployees = new ArrayList<>();
	

	public List<Employee> getReportingEmployees() {
		return reportingEmployees;
	}

	public void setReportingEmployees(List<Employee> reportingEmployees) {
		this.reportingEmployees = reportingEmployees;
	}

	private static final BigDecimal MANAGER_ALLOCATION_AMOUNT = new BigDecimal(300);

	@Override
	public BigDecimal getAllocationAmount() {
		return MANAGER_ALLOCATION_AMOUNT;
	}

	@Override
	public EmployeeType getEmployeeType() {
		return EmployeeType.MANAGER;
	}

}
