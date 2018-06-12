package com.akshay.testcases;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import com.akshay.department.*; 
import org.junit.Test;

import com.akshay.AllocationHelper;

public class UT_AllocationHelper {
	
	/**
	 * Testing  Department with employees
	 *  Department
	 *    -Manager
	 *     -Tester
	 *     -Developer
	 */
	
	@Test
	public void testDptAllocWithMngrDevTester() {
		List<Employee> employees = new ArrayList<>();
		Manager manager = new Manager();
		Developer developer = new Developer();
		Tester tester = new Tester();
		employees.add(tester);
		employees.add(developer);
		employees.add(manager);
		Department department = new Department();
		department.setEmployees(employees);
		assertEquals(new BigDecimal(1800), AllocationHelper.calculateDepartmentAllocation(department));
	}
	
	
	/**
	 * Testing  Department with employees
	 *  Department
	 *    -Developer
	 *    -Tester
	 *    -Manager
	 *     -Tester
	 *     -Developer
	 */
	@Test
	public void testDptAllocWithEmployeesUnderMngrandDevTester() {
		List<Employee> employees = new ArrayList<>();
		List<Employee> reportingEmployees = new ArrayList<>();
		Manager manager = new Manager();
		Developer developer = new Developer();
		Tester tester = new Tester();
		reportingEmployees.add(tester);
		reportingEmployees.add(developer);
		manager.setReportingEmployees(reportingEmployees);
		employees.add(tester);
		employees.add(developer);
		employees.add(manager);
		Department department = new Department();
		department.setEmployees(employees);
		assertEquals(new BigDecimal(3300), AllocationHelper.calculateDepartmentAllocation(department));
	}
	
	
	/**
	 * Testing  Department with employees
	 *  Department
	 *    -Developer
	 *    -Tester
	 *    -Manager
	 *     -Manager
	 *     -Tester
	 *     -Developer
	 */
	@Test
	public void testDptAllocWithReportingMngrUnderMngrandDevTester() {
		List<Employee> employees = new ArrayList<>();
		List<Employee> reportingEmployees = new ArrayList<>();
		Manager manager = new Manager();
		Developer developer = new Developer();
		Tester tester = new Tester();
		reportingEmployees.add(tester);
		reportingEmployees.add(developer);
		reportingEmployees.add(new Manager());
		manager.setReportingEmployees(reportingEmployees);
		employees.add(tester);
		employees.add(developer);
		employees.add(manager);
		Department department = new Department();
		department.setEmployees(employees);
		assertEquals(new BigDecimal(3600), AllocationHelper.calculateDepartmentAllocation(department));
	}

	
	/**
	 * Testing  Manager with employees
	 *  Department
	 *    -Manager
	 *     -Tester
	 *     -Developer
	 *     -Tester
	 *     -Developer
	 */
	@Test
	public void testMngrWithReportingDevsAndTesters() {

		List<Employee> reportingEmployees = new ArrayList<>();
		Manager manager = new Manager();
		Developer developer = new Developer();
		Tester tester = new Tester();
		reportingEmployees.add(tester);
		reportingEmployees.add(developer);
		reportingEmployees.add(tester);
		reportingEmployees.add(developer);
		reportingEmployees.add(new Manager());
		manager.setReportingEmployees(reportingEmployees);

		assertEquals(new BigDecimal(3600), AllocationHelper.calculateEmployeeAllocation(manager));
	}

	
	/**
	 * Testing  Manager with employees
	 *  Department
	 *    -Manager
	 *     -Manager
	 *     -Tester
	 *     -Developer
	 */
	@Test
	public void testMngrWithReportingDevAndTester() {

		List<Employee> reportingEmployees = new ArrayList<>();
		Manager manager = new Manager();
		Developer developer = new Developer();
		Tester tester = new Tester();
		reportingEmployees.add(tester);
		reportingEmployees.add(developer);
		reportingEmployees.add(new Manager());
		manager.setReportingEmployees(reportingEmployees);

		assertEquals(new BigDecimal(2100), AllocationHelper.calculateEmployeeAllocation(manager));
	}
	
	
	/**
	 * Testing  Manager with employees
	 *  Department
	 *    -Manager
	 *     -Developer
	 *     -Tester
	 *     -Manager
	 *      -Tester
	 *      -Developer
	 */
	@Test
	public void testMngrWithReportingMngrWithDevAndTester() {

		List<Employee> reportingEmployees = new ArrayList<>();
		Manager manager = new Manager();
		Developer developer = new Developer();
		Tester tester = new Tester();
		reportingEmployees.add(tester);
		reportingEmployees.add(developer);
		Manager managerTwo = new Manager();
		List<Employee> managerTwoReportingEmployees = new ArrayList<>();
		managerTwoReportingEmployees.add(developer);
		managerTwoReportingEmployees.add(tester);
		managerTwo.setReportingEmployees(managerTwoReportingEmployees);
		reportingEmployees.add(managerTwo);
		manager.setReportingEmployees(reportingEmployees);

		assertEquals(new BigDecimal(3600), AllocationHelper.calculateEmployeeAllocation(manager));
	}
	
	
    /**Null check*/
	@Test
	public void testCalcEmployeeAllocWithNoMngr() {

		assertEquals(BigDecimal.ZERO, AllocationHelper.calculateEmployeeAllocation(null));
	}

	/**Null check*/
	@Test
	public void testDeptAllocWithoutEmployees() {

		assertEquals(BigDecimal.ZERO, AllocationHelper.calculateDepartmentAllocation(null));
	}

}
