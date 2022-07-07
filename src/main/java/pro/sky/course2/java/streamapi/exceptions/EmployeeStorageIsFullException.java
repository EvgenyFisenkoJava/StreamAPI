package pro.sky.course2.java.streamapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INSUFFICIENT_STORAGE, reason = "ArrayIsFull")
public class EmployeeStorageIsFullException extends IndexOutOfBoundsException {
    public EmployeeStorageIsFullException() {
        super();
    }
}
