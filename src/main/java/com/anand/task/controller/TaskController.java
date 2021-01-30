package com.anand.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.anand.task.constants.URLCons;
import com.anand.task.entity.EmployeeInfo;
import com.anand.task.service.TaskService;

/**
 * TaskController is a controller class used for handling Task API requests
 * 
 * @author ANAND MUTHUKUMAR
 * @since 23-01-2021
 */
@RestController
@RequestMapping(produces = URLCons.JSON_UTF8_ENCODING)
public class TaskController {

	@Autowired
	protected TaskService taskService;

	@ResponseBody
	@PostMapping(value = URLCons.GET_EMPLOYEE)
	public EmployeeInfo getEmployee(@RequestParam int empId) {
		return taskService.getEmployee(empId);
	}

	@ResponseBody
	@PostMapping(value = URLCons.LOAD_EMPLOYEE)
	public List<EmployeeInfo> loadAllEMployee() {
		return taskService.getAllEmployee();
	}

	@ResponseBody
	@PostMapping(value = URLCons.CREATE_EMPLOYEE)
	public String createEmployee(@ModelAttribute EmployeeInfo employeeInfo) {
		return taskService.createEmployee(employeeInfo);
	}

	@ResponseBody
	@PostMapping(value = URLCons.UPDATE_EMPLOYEE)
	public String updateEmployee(@ModelAttribute EmployeeInfo employeeInfo) {
		return taskService.updateEmployee(employeeInfo);
	}

	@ResponseBody
	@PostMapping(value = URLCons.DELETE_EMPLOYEE)
	public String deleteEmployee(@RequestParam int empId) {
		return taskService.deleteEmployee(empId);
	}
}