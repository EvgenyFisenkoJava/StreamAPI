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

    public List<Employee> getDepList(int departmentID) {
        List<Employee> employeeByDepartment = employeeService.getList();

        return employeeByDepartment.stream()
                .filter(employee -> employee.getDepartmentID() == departmentID)
                .collect(Collectors.toList());
    }

    public Employee maxSalary(int departmentID) {
        List<Employee> salary = employeeService.getList();
        var employee1 = salary.stream()
                .filter(employee -> employee.getDepartmentID() == departmentID)
                .max(Comparator.comparingInt(employee -> employee.getSalary())).get();

        return employee1;
    }

    public Employee minSalary(int departmentID) {
        List<Employee> salary = employeeService.getList();
        var employee1 = salary.stream()
                .filter(employee -> employee.getDepartmentID() == departmentID)
                .min(Comparator.comparingInt(employee -> employee.getSalary())).get();

        return employee1;
    }


    public List<Employee> getAllDepList() {
        List<Employee> allEmployees = employeeService.getList();
        List<Employee> sortedByDep = allEmployees.stream()
                .sorted(Comparator.comparingInt(Employee::getDepartmentID))
                .collect(Collectors.toList());

        return sortedByDep;
    }


}
