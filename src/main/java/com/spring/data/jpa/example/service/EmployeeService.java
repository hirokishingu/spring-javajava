package com.spring.data.jpa.example.service;

import java.util.List;
import java.util.Set;

import com.spring.data.jpa.example.repository.entity.Department;
import com.spring.data.jpa.example.repository.entity.Employee;

public interface EmployeeService {
	public List<Employee> getEmployeeList(Employee employee);

	public List<Department> getDepartmentList();

	public Employee  saveEmployee(Employee employee);

	public int deleteEmployee(Set<Integer> nos);

	public Employee getEmployee(Integer no);
}
