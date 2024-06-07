package ma.enset.hospital.service;

import ma.enset.hospital.entities.Employee;
import ma.enset.hospital.entities.Project;
import ma.enset.hospital.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private EmployeeService employeeService;

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Project saveProject(Project project) {
        return projectRepository.save(project);
    }

    public Project findById(Long id) {
        return projectRepository.findById(id).orElse(null);
    }

    public void assignEmployeeToProject(Long projectId, Long employeeId) {
        Project project = findById(projectId);
        Employee employee = employeeService.findById(employeeId);
        if (project != null && employee != null) {
            project.getEmployees().add(employee);
            projectRepository.save(project);
        }
    }
}

