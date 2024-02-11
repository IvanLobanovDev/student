package telran.java51.student.dto;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

//Это DTO для возвращаемого JSON, поэтому нужно сделать конструктор

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    Integer id;
    String name;
    Map<String, Integer> scores;

}
