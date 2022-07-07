package pro.sky.course2.java.streamapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.course2.java.streamapi.Employee;
import pro.sky.course2.java.streamapi.service.DepartmentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(value = "/all", params = {"departmentID"})
    public List<Employee> employeesByDep(@RequestParam(value = "departmentID") int departmentID) {
        return departmentService.getDepList(departmentID);
    }

    @GetMapping("/max-salary")
    public Employee maxSalary(@RequestParam("departmentID") int departmentID) {
        return departmentService.maxSalary(departmentID);

    }

    @GetMapping("/min-salary")
    public Employee minSalary(@RequestParam("departmentID") int departmentID) {
        return departmentService.minSalary(departmentID);

    }

    @GetMapping("/all")
    public List<Employee> allEmployees() {
        return departmentService.getAllDepList();
    }

}
