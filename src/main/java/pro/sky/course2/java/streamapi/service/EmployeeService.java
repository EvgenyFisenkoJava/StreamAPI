package pro.sky.course2.java.streamapi.service;

import org.springframework.stereotype.Service;
import pro.sky.course2.java.streamapi.Employee;
import pro.sky.course2.java.streamapi.exceptions.EmployeeAlreadyAddedException;
import pro.sky.course2.java.streamapi.exceptions.EmployeeNotFoundException;
import pro.sky.course2.java.streamapi.exceptions.EmployeeStorageIsFullException;

import java.util.*;

@Service
public class EmployeeService {
    private static final int LIMIT = 10;

    private final Map<String, Employee> employees = new HashMap<>();
    public Object stream;

    public Employee addEmployee(String firstName, String lastName, int department, int salary) {
        Employee employee = new Employee(firstName, lastName, department, salary);
        String key = getKey(firstName, lastName);
        if (employees.containsKey(key)) {
            throw new EmployeeAlreadyAddedException();
        }
        if (employees.size() < LIMIT) {
            employees.put(key, employee);
            return employee;
        }
        throw new EmployeeStorageIsFullException();
    }


    public Employee findEmployee(String firstName, String lastName) {
        String key = getKey(firstName, lastName);
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException();
        }
        return employees.get(key);
    }

    public Employee removeEmployee(String firstName, String lastName) {
        String key = getKey(firstName, lastName);
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException();
        }
        return employees.remove(key);
    }

    public List<Employee> getList() {
        return new ArrayList<>(employees.values());
    }

    public String getKey(String firstName, String lastName) {
        return firstName + " " + lastName;
    }

}
