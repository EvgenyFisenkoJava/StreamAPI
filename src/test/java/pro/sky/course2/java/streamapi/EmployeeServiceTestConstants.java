package pro.sky.course2.java.streamapi;

import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceTestConstants {

    public static String FIRST_NAME1 = "John";
    public static String LAST_NAME1 = "Smith";
    public static final String FIRST_NAME2 = "Mary";
    public static String LAST_NAME2 = "Jane";
    public static int DEPARTMENT1 = 9;
    public static int DEPARTMENT2 = 10;

    public static int SALARY1 = 123456;
    public static int SALARY2 = 56789;
    public static Employee employee1 = new Employee("James", "Brown", 2, 15000);
    public static Employee employee2 = new Employee("Michael", "Jackson", 2, 25000);
    public static Employee employee3 = new Employee("Bobby", "Bird", 3, 35000);
    public static final List<Employee> testEmployee = new ArrayList<Employee>(List.of(employee1, employee2, employee3));
    public static final List<Employee> testEmployeeByDep = new ArrayList<Employee>(List.of(employee1, employee2));








}
