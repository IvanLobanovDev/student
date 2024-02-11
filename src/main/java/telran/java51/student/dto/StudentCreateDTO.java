package telran.java51.student.dto;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

//Лучше использовать в DTO Wrapper class, чтобы избежать ситуацию, когда поле не инициализируется и дефолтным значением в нем будет 0
//При враппер классе будет null и мы сможем отличать не указанные значение от значений 0, которые были установлены умышленно
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StudentCreateDTO {
	Integer id;
	String name;
	String password;
}
