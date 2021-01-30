package com.anand.task.dao;

import java.util.List;

import com.anand.task.entity.EmployeeInfo;

/**
 * TaskDao is a DAO interface used for handling all the DB information
 * 
 * @author ANAND MUTHUKUMAR
 * @since 23-01-2021
 */
public interface TaskDao {

	EmployeeInfo getEmployee(int empId);

	List<EmployeeInfo> getAllEmployee();

	String createEmployee(EmployeeInfo employeeInfo);

	String updateEmployee(EmployeeInfo employeeInfo);

	String deleteEmployee(int empId);

}