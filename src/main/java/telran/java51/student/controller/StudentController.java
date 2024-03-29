package telran.java51.student.controller;

import java.util.List;
import java.util.Set;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import telran.java51.student.dto.ScoreDto;
import telran.java51.student.dto.StudentCreateDTO;
import telran.java51.student.dto.StudentDto;
import telran.java51.student.dto.StudentUpdateDto;
import telran.java51.student.service.StudentService;

@RestController
//Конструктор только для final полей
@RequiredArgsConstructor
public class StudentController{
	
//	Если есть конструктор, ставить @Autowired не нужно. Спринг сам понимает, что он нужен
	final StudentService studentService;

	@PostMapping("/student")
	public Boolean addStudent(@RequestBody StudentCreateDTO studentCreateDto) {
		return studentService.addStudent(studentCreateDto);
	}

//	@PathVariable говорит, что значение Integer id нужно взять из пути "student/{studentId}"
	@GetMapping("student/{studentId}")
	public StudentDto findStudent(@PathVariable("studentId") Integer id) {
		return studentService.findStudent(id);
	}

	@DeleteMapping("student/{id}")
	public StudentDto removeStudent(@PathVariable Integer id) {
		return studentService.removeStudent(id);
	}

	@PutMapping("student/{id}")
	public StudentCreateDTO updateStudent(@PathVariable Integer id, @RequestBody StudentUpdateDto studentUpdateDto) {
		return studentService.updateStudent(id, studentUpdateDto);
	}

	@PutMapping("score/student/{id}")
	public Boolean addScore(@PathVariable Integer id, @RequestBody ScoreDto scoreDto) {
		return studentService.addScore(id, scoreDto);
	}

	@GetMapping("students/name/{name}")
	public List<StudentDto> findStudentsByName(@PathVariable String name) {
		return studentService.findStudentsByName(name);
	}

	@PostMapping("quantity/students")
	public Long getStudentsNamesQuantity(@RequestBody Set<String> names) {
		return studentService.getStudentsNamesQuantity(names);
	}

	@GetMapping("students/exam/{exam}/minscore/{minScore}")
	public List<StudentDto> getStudentsByExamMinScore(@PathVariable String exam, @PathVariable Integer minScore) {
		return studentService.getStudentsByExamMinScore(exam, minScore);
	}

	
}
