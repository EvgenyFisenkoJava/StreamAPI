package pro.sky.course2.java.streamapi.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static pro.sky.course2.java.streamapi.EmployeeServiceTestConstants.*;


@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {

    @Mock
    private EmployeeService employeeMock;
    @InjectMocks
    private DepartmentService departmentMock;

    @Test
    void ShouldCallDepartmentServiceMethodGetDepList() {
        when(employeeMock.getList()).thenReturn(testEmployeeByDep);
        assertEquals(testEmployeeByDep, departmentMock.getDepList(2));
    }

    @Test
    void ShouldCallDepartmentServiceMethodMaxSalary() {
        when(employeeMock.getList()).thenReturn(testEmployee);
        assertEquals(employee2, departmentMock.maxSalary(2));
    }

    @Test
    void ShouldCallDepartmentServiceMethodMinSalary() {

        when(employeeMock.getList()).thenReturn(testEmployee);
        assertEquals(employee1, departmentMock.minSalary(2));
    }

    @Test
    void ShouldCallDepartmentServiceMethodGetAllDepList() {
        when(employeeMock.getList()).thenReturn(testEmployee);
        assertEquals(testEmployee, departmentMock.getAllDepList());
    }

    @Test
    public void shouldThrowExceptionWhenDepartmentServiceThrowsExceptions() {
        assertThrows(IllegalArgumentException.class, () -> departmentMock.getDepList(null));
    }
}