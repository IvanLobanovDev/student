package telran.java51.student.dto.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Класс создается для того, чтобы бросить эксепшен в случае, если такого студента нет
// HttpStatus.NOT_FOUND - Энам для 404 кода
@ResponseStatus(HttpStatus.NOT_FOUND)
public class StudentNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 9206193413387350987L;


}
