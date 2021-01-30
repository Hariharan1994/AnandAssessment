package com.anand.task.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.anand.task.entity.EmployeeInfo;

/**
 * TaskService is a Service interface used for handling the Task request
 * 
 * @author ANAND MUTHUKUMAR
 * @since 23-01-2021
 */
@Service
public interface TaskService {

	EmployeeInfo getEmployee(int empId);

	List<EmployeeInfo> getAllEmployee();

	String createEmployee(EmployeeInfo employeeInfo);

	String updateEmployee(EmployeeInfo employeeInfo);

	String deleteEmployee(int empId);

}