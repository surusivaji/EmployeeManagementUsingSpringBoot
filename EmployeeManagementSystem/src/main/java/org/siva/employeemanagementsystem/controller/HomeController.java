package org.siva.employeemanagementsystem.controller;

import java.util.List;

import org.siva.employeemanagementsystem.model.Employee;
import org.siva.employeemanagementsystem.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/employeemanagementsystem")
public class HomeController {
	
	@Autowired
	private IEmployeeService employeeService;

	@GetMapping("/")
	public String getHomePage() {
		return "index";
	}
	
	@GetMapping("/addemployee")
	public String addEmployeePage(Model model) {
		model.addAttribute("employee", new Employee());
		return "AddEmployee";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@Valid @ModelAttribute Employee employee, BindingResult bindingResult, HttpSession session) {
		if (bindingResult.hasErrors()) {
			return "AddEmployee";
		}
		else {
			Employee save = employeeService.addEmployee(employee);
			if (save!=null) {
				System.out.println("employee added successfully");
				return "redirect:/employeemanagementsystem/displayemployees";
			}
			else {
				System.out.println("something went wrong on the server");
				return "redirect:/employeemanagementsystem/addemployee";
			}
		}
	}
	
	@GetMapping("/displayemployees")
	public String displayEmployeePage(Model model) {
		List<Employee> employees = employeeService.displayAllEmployees();
		model.addAttribute("employees", employees);
		return "DisplayEmployees";
	}
	
	@GetMapping("/editemployee/{id}")
	public String editEmployeePage(@PathVariable int id, Model model) {
		Employee employee = employeeService.getEmployee(id);
		if (employee!=null) {
			model.addAttribute("employee", employee);
			return "EditEmployee";
		}
		else {
			System.out.println("this id does not exist in the database");
			return "redirect:/employeemanagementsystem/displayemployees";
		}
	}
	
	@PostMapping("/update")
	public String updateEmployeePage(@Valid @ModelAttribute Employee employee, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "redirect:/employeemanagementsystem/editemployee/{id}";
		}
		else {
			Employee emp = employeeService.addEmployee(employee);
			if (emp!=null) {
				System.out.println("employee updated successfully");
				return "redirect:/employeemanagementsystem/displayemployees";
			}
			else {
				System.out.println("something went wrong on the server");
				return "redirect:/employeemanagementsystem/displayemployees";
			}
		}
	}
	
	@GetMapping("/remove/{id}")
	public String removeEmployee(@PathVariable int id) {
		boolean deleteEmployee = employeeService.deleteEmployee(id);
		if (deleteEmployee) {
			System.out.println("employee deleted successfully");
			return "redirect:/employeemanagementsystem/displayemployees";
		}
		else {
			System.out.println("something went wrong on the server");
			return "redirect:/employeemanagementsystem/displayemployees";
		}
	}


}
