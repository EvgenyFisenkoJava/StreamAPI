package pro.sky.course2.java.streamapi.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.course2.java.streamapi.Employee;
import pro.sky.course2.java.streamapi.exceptions.EmployeeAlreadyAddedException;
import pro.sky.course2.java.streamapi.exceptions.EmployeeNotFoundException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.course2.java.streamapi.EmployeeServiceTestConstants.*;

class EmployeeServiceTest {
    private Employee employeeExpected1;
    private Employee employeeExpected2;
    private Employee employeeActual1;
    private Employee employeeActual2;

    private EmployeeService employeeService;

    @BeforeEach
    public void setUp() {
        employeeExpected1 = new Employee(FIRST_NAME1, LAST_NAME1, DEPARTMENT1, SALARY1);
        employeeExpected2 = new Employee(FIRST_NAME2, LAST_NAME2, DEPARTMENT2, SALARY2);
        employeeService = new EmployeeService();
        employeeActual1 = employeeService.addEmployee(FIRST_NAME1, LAST_NAME1, DEPARTMENT1, SALARY1);
        employeeActual2 = employeeService.addEmployee(FIRST_NAME2, LAST_NAME2, DEPARTMENT2, SALARY2);

    }

    @Test
    void shouldCallEmployeeServiceMethodWhenAddEmployee() {

        assertEquals(employeeExpected1, employeeActual1);

    }

    @Test
    void shouldCallEmployeeServiceMethodWhenFindEmployee() {
        employeeActual1 = employeeService.findEmployee(FIRST_NAME1, LAST_NAME1);
        assertEquals(employeeExpected1, employeeActual1);

    }

    @Test
    void shouldCallEmployeeServiceMethodWhenRemoveEmployee() {
        employeeActual1 = employeeService.removeEmployee(FIRST_NAME2, LAST_NAME2);
        assertEquals(employeeExpected2, employeeActual2);

    }

    @Test
    public void shouldCallEmployeeServiceMethodWhenGetListOfEmployees() {

        List<Employee> expected = employeeService.getList();

        List<Employee> actual = new ArrayList<Employee>();

        actual.add(employeeExpected1);
        actual.add(employeeExpected2);

        assertEquals(expected, actual);
    }

    @Test
    public void getListNotNull() {
        EmployeeService employeeService = new EmployeeService();
        List<Employee> expected = employeeService.getList();
        assertNotNull(expected);
    }

    @Test
    public void shouldThrowExceptionWhenFindEmployee() {
        assertThrows(EmployeeNotFoundException.class,
                () -> employeeService.findEmployee(FIRST_NAME1, LAST_NAME2));
    }

    @Test
    public void shouldThrowExceptionWhenAddEmployee() {
        assertThrows(EmployeeAlreadyAddedException.class,
                () -> employeeService.addEmployee(FIRST_NAME1, LAST_NAME1, DEPARTMENT1, SALARY1));
    }

    @Test
    public void shouldThrowExceptionWhenRemoveEmployee() {
        assertThrows(EmployeeNotFoundException.class,
                () -> employeeService.removeEmployee(FIRST_NAME2, LAST_NAME1));
    }
}