package telran.java51;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentServiceApplication {

	public static void main(String[] args) {
//		При старте программы метод run создает контекст, внутри которого хранятся нужные Спрингу методы для работы
//		Чтобы созданный нами объект класса попал в контекст, нужно пометить его, как компонент, дать ему аннотацию @Component
//		А ссылкам на репозиторий и контроллер дать аннотации 	@Autowired, чтобы связать с ними компоненты
		SpringApplication.run(StudentServiceApplication.class, args);
	}

}
