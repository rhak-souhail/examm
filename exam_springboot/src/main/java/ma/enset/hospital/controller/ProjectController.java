package ma.enset.hospital.controller;

import ma.enset.hospital.entities.Project;
import ma.enset.hospital.service.EmployeeService;
import ma.enset.hospital.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProjectController {
    @Autowired
    private ProjectService projectService;
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/projects")
    public String listProjects(Model model) {
        model.addAttribute("projects", projectService.getAllProjects());
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "projects";
    }

    @PostMapping("/projects")
    public String saveProject(@RequestParam String name) {
        Project project = new Project();
        project.setName(name);
        projectService.saveProject(project);
        return "redirect:/projects";
    }

    @PostMapping("/projects/assign")
    public String assignEmployeeToProject(@RequestParam Long projectId, @RequestParam Long employeeId) {
        projectService.assignEmployeeToProject(projectId, employeeId);
        return "redirect:/projects";
    }
}
