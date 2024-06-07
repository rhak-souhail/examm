package ma.enset.hospital.controller;

import ma.enset.hospital.entities.Employee;
import ma.enset.hospital.entities.Role;
import ma.enset.hospital.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public String listEmployees(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "employees";
    }

    @PostMapping("/employees")
    public String saveEmployee(@RequestParam String name, @RequestParam Role role) {
        Employee employee = new Employee();
        employee.setName(name);
        employee.setRole(role);
        employeeService.saveEmployee(employee);
        return "redirect:/employees";
    }
}
