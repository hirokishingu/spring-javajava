package com.spring.data.jpa.example.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.data.jpa.example.repository.DepartmentRepository;
import com.spring.data.jpa.example.repository.EmployeeRepository;
import com.spring.data.jpa.example.repository.EmployeeSpecification;
import com.spring.data.jpa.example.repository.entity.Department;
import com.spring.data.jpa.example.repository.entity.Employee;

@Service
@Transactional(readOnly = true)
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public List<Employee> getEmployeeList(Employee employee) {
		return employeeRepository.findAll(Specifications
				.where(EmployeeSpecification
						.firstName(employee.getFirstName()))
						.and(EmployeeSpecification.lastName(employee.getLastName()))
						.and(EmployeeSpecification.sex(employee.getSex()))
						.and(EmployeeSpecification.birthdayEquals(employee.getBirthday()))
						.and(EmployeeSpecification.mailAddress(employee.getMailAddress()))
						.and(EmployeeSpecification.department(employee.getDepartment())));
	}

	@Override
	@Transactional
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	@Transactional
	public int deleteEmployee(Set<Integer> nos) {
		nos.forEach(no -> employeeRepository.delete(no));
		return nos.size();
	}

	@Override
	public List<Department> getDepartmentList() {
		return departmentRepository.findAll();
	}

	@Override
	public Employee getEmployee(Integer no) {
		return employeeRepository.findOne(no);
	}

}
