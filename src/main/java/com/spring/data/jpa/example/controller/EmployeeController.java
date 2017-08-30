package com.spring.data.jpa.example.controller;

import java.text.SimpleDateFormat;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.data.jpa.example.repository.entity.Employee;
import com.spring.data.jpa.example.service.EmployeeService;

@Controller
@RequestMapping("employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(java.sql.Date.class, new CustomDateEditor(dateFormat, true));
	}

	@RequestMapping("list")
	public String list(@ModelAttribute Employee employee, Model model) {
		model.addAttribute("employees", employeeService.getEmployeeList(employee));
		model.addAttribute("departments", employeeService.getDepartmentList());

		return "employee/list";
	}

	@RequestMapping(path = "list", params = "insertAction")
	public String insert(@ModelAttribute Employee employee, Model model) {
		employeeService.saveEmployee(employee);

		return "redirect:list";
	}

	@RequestMapping("delete")
	public String delete(@RequestParam(name = "nos") Set<Integer> nos, Model model) {
		employeeService.deleteEmployee(nos);

		return "redirect:list";
	}

	@RequestMapping("edit")
	public String edit(@RequestParam(name = "no") Integer no, Model model) {
		model.addAttribute("employee", employeeService.getEmployee(no));
		model.addAttribute("departments", employeeService.getDepartmentList());

		return "employee/edit";
	}

	@RequestMapping("save")
	public String save(@ModelAttribute Employee employee, Model model, Errors errors) {
		try {
			employeeService.saveEmployee(employee);
		} catch(OptimisticLockingFailureException e) {
			errors.reject("error.lock.optimistic");
			model.addAttribute("departments", employeeService.getDepartmentList());
			return "employee/edit";
		}
		return "redirect:list";
	}

}
