package telran.java51.student.model;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
//в аннотации указываем название коллекции в DB
@Document(collection = "students")
@NoArgsConstructor
public class Student {
//	Для МонгоДБ поле id является первичным ключом, если такого нет нужно над любым полем поставить аннотацию @Id
	int id;
	@Setter
	String name;
	@Setter
	String password;
    Map<String, Integer> scores = new HashMap<>();
    
	public Student(int id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
	}
	
	public boolean addScore(String exam, int score) {
		
//		При добавлении put возвращает то что ранее было замещено, если там был null, значит это первая сдача экзамена
		return scores.put(exam, score) == null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Student)) {
			return false;
		}
		Student other = (Student) obj;
		if (id != other.id) {
			return false;
		}
		return true;
	}
	
	
    
}
