import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import uni.eszterhazy.beadando.dao.StudentDAO;
import uni.eszterhazy.beadando.dao.relational.StudentDAORelation;
import uni.eszterhazy.beadando.service.StudentsService;
import uni.eszterhazy.beadando.service.impl.StudentServiceImpl;

@Configuration
@ComponentScan({"uni.eszterhazy.beadando.controller"})
public class MyConfig {

    //Bean-eket vissza adó metódusok
    @Bean
    public StudentDAO mysql(){
        return new StudentDAORelation();
    }

    @Bean
    public StudentsService studentsService(StudentDAO sDao){
        return new StudentServiceImpl(sDao);
    }
}
