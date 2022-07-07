package pro.sky.course2.java.streamapi.service;

import org.springframework.stereotype.Service;
import pro.sky.course2.java.streamapi.Employee;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private final EmployeeService employeeService;


    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public List<Employee> getDepList(Integer departmentID) {
        List<Employee> employeeByDepartment = employeeService.getList();
        return employeeByDepartment.stream()
                .filter(employee -> employee.getDepartmentID().equals(departmentID))
                .collect(Collectors.toList());
    }

    public Employee maxSalary(Integer departmentID) {
        List<Employee> salary = employeeService.getList();
        return salary.stream()
                .filter(employee -> employee.getDepartmentID().equals(departmentID))
                .max(Comparator.comparingInt(Employee::getSalary)).get();
    }

    public Employee minSalary(Integer departmentID) {
        List<Employee> salary = employeeService.getList();
        return salary.stream()
                .filter(employee -> employee.getDepartmentID().equals(departmentID))
                .min(Comparator.comparingInt(Employee::getSalary)).get();
    }

    public List<Employee> getAllDepList() {
        List<Employee> allEmployees = employeeService.getList();
        allEmployees = allEmployees.stream()
                .sorted(Comparator.comparingInt(Employee::getDepartmentID))
                .collect(Collectors.toList());
        return allEmployees;
    }
}
