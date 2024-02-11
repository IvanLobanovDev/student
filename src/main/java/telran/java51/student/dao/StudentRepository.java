package telran.java51.student.dao;

import java.util.Set;
import java.util.stream.Stream;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import telran.java51.student.model.Student;

public interface StudentRepository extends CrudRepository<Student, Integer>{
	
	Stream<Student> getAllBy();
	
	Stream<Student> findByNameIgnoreCase(String name);
	
	Long countByNameInIgnoreCase(Set<String> names);
//	@Query("{'scores.math' : {$gte : 90}}")
	@Query("{'scores.?0' : {$gte : ?1}}")
	Stream<Student> findByExamAndScoreGreaterThan(String exam, Integer minScore);

}
