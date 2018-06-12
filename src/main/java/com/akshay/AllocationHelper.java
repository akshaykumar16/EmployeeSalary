package com.akshay;

import java.math.BigDecimal;

import com.akshay.department.Department;
import com.akshay.department.Employee;
import com.akshay.department.EmployeeType;
import com.akshay.department.Manager;

public class AllocationHelper {
	public static BigDecimal calculateEmployeeAllocation(Employee employee) {
		if (null != employee) {
			BigDecimal totalAllocation = employee.getAllocationAmount();
			if (EmployeeType.MANAGER.equals(employee.getEmployeeType())) {
				Manager manager = (Manager) employee;
				for (Employee directReport : manager.getReportingEmployees()) {
					totalAllocation = totalAllocation.add(calculateEmployeeAllocation(directReport));
				}
			}
			return totalAllocation;
		}
		return BigDecimal.ZERO;
	}

	public static BigDecimal calculateDepartmentAllocation(Department department) {
		BigDecimal totalAllocation = BigDecimal.ZERO;
		if (null != department) {
			for (Employee employee : department.getEmployees()) {

				totalAllocation = totalAllocation.add(calculateEmployeeAllocation(employee));
			}
		}
		return totalAllocation;
	}
}
