package com.anand.task.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anand.task.dao.TaskDao;
import com.anand.task.entity.EmployeeInfo;

/**
 * TaskServiceImpl is a Service implementation class for handling Task request
 * 
 * @author ANAND MUTHUKUMAR
 * @since 23-01-2021
 */
@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	public TaskDao taskDao;

	public EmployeeInfo getEmployee(int empId) {
		return taskDao.getEmployee(empId);
	}

	public List<EmployeeInfo> getAllEmployee() {
		return taskDao.getAllEmployee();
	}

	public String createEmployee(EmployeeInfo employeeInfo) {
		return taskDao.createEmployee(employeeInfo);
	}

	public String updateEmployee(EmployeeInfo employeeInfo) {
		return taskDao.updateEmployee(employeeInfo);
	}

	public String deleteEmployee(int empId) {
		return taskDao.deleteEmployee(empId);
	}

}