package pro.sky.course2.java.streamapi;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class Employee {
    private final String firstName;
    private final String lastName;
    private final Integer departmentID;
    private final int salary;


    public Employee(String firstName, String lastName, Integer departmentID, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.departmentID = departmentID;
        this.salary = salary;

    }


    public String getFirstName() {
        return StringUtils.capitalize(firstName);
    }

    public String getLastName() {
        return StringUtils.capitalize(lastName);
    }

    public Integer getDepartmentID() {
        return this.departmentID;
    }

    public int getSalary() {
        return this.salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

}
