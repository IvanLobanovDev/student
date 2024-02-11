package telran.java51.student.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import telran.java51.student.dao.StudentRepository;
import telran.java51.student.dto.ScoreDto;
import telran.java51.student.dto.StudentCreateDTO;
import telran.java51.student.dto.StudentDto;
import telran.java51.student.dto.StudentUpdateDto;
import telran.java51.student.dto.exceptions.StudentNotFoundException;
import telran.java51.student.model.Student;

//Кладем класс в аппликационный контекст Спринг
@Service
//Конструктор только для final полей
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

//	Если есть конструктор, ставить @Autowired не нужно. Спринг сам понимает, что он нужен
	final StudentRepository studentRepository;
	final ModelMapper modelMapper;

	@Override
	public Boolean addStudent(StudentCreateDTO studentCreateDto) {
		if (studentRepository.existsById(studentCreateDto.getId())) {
			return false;
		}
//		Student student = new Student(studentCreateDto.getId(), studentCreateDto.getName(),
//				studentCreateDto.getPassword());
//		Создание студента при помощи modelMapper
		Student student = modelMapper.map(studentCreateDto, Student.class);
		studentRepository.save(student);
		return true;
	}

	@Override
	public StudentDto findStudent(Integer id) {
		Student student = studentRepository.findById(id).orElseThrow(StudentNotFoundException::new);
//		return new StudentDto(id, student.getName(), student.getScores());
		return modelMapper.map(student, StudentDto.class);
	}

	@Override
	public StudentDto removeStudent(Integer id) {
		Student student = studentRepository.findById(id).orElseThrow(StudentNotFoundException::new);
		studentRepository.deleteById(id);
//		return new StudentDto(id, student.getName(), student.getScores());
		return modelMapper.map(student, StudentDto.class);
	}

	@Override
	public StudentCreateDTO updateStudent(Integer id, StudentUpdateDto studentUpdateDto) {
		Student student = studentRepository.findById(id).orElseThrow(StudentNotFoundException::new);
//		StudentCreateDTO victim = new StudentCreateDTO(id, student.getName(), student.getPassword());
		student.setName(studentUpdateDto.getName());
		student.setPassword(studentUpdateDto.getPassword());
		studentRepository.save(student);
		return modelMapper.map(student, StudentCreateDTO.class);
	}

	@Override
	public Boolean addScore(Integer id, ScoreDto scoreDto) {
		Student student = studentRepository.findById(id).orElseThrow(StudentNotFoundException::new);
		boolean res = student.addScore(scoreDto.getExamName(), scoreDto.getScore());
		studentRepository.save(student);
		return res;
	}

	@Override
	public List<StudentDto> findStudentsByName(String name) {
//		return StreamSupport.stream(studentRepository.findAll().spliterator(), false)
//		return studentRepository.getAllBy()
//		.filter(s -> s.getName().equalsIgnoreCase(name))
		return studentRepository.findByNameIgnoreCase(name)
//				.map(s -> new StudentDto(s.getId(), s.getName(), s.getScores()))
				.map(s -> modelMapper.map(s, StudentDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public Long getStudentsNamesQuantity(Set<String> names) {
//		return StreamSupport.stream(studentRepository.findAll().spliterator(), false)
//				.filter(s -> names.contains(s.getName())).count();
		return studentRepository.countByNameInIgnoreCase(names);
	}

	@Override
	public List<StudentDto> getStudentsByExamMinScore(String exam, Integer minScore) {
//		return StreamSupport.stream(studentRepository.findAll().spliterator(), false)
//				.filter(s -> s.getScores().containsKey(exam) && s.getScores().get(exam) >= minScore)
		return studentRepository.findByExamAndScoreGreaterThan(exam, minScore)
//				.map(s -> new StudentDto(s.getId(), s.getName(), s.getScores()))
				.map(s -> modelMapper.map(s, StudentDto.class))
				.collect(Collectors.toList());
	}

}

//GitHub - зарегаться
