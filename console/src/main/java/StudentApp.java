import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import uni.eszterhazy.beadando.controller.StudentController;
import uni.eszterhazy.beadando.dao.StudentDAO;
import uni.eszterhazy.beadando.model.Student;
import uni.eszterhazy.beadando.service.StudentsService;
import uni.eszterhazy.beadando.service.impl.StudentServiceImpl;

public class StudentApp {
    public static void main(String[] args) {
        /*ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        //StudentDAO sDao = (StudentDAO) context.getBean("mysql");
        StudentsService service = (StudentsService) context.getBean("studentsService");
        System.out.println(service.getAllStudent());*/

        ApplicationContext context = new ClassPathXmlApplicationContext("application-config.xml");
        StudentsService service = (StudentsService) context.getBean("studentsService");
        System.out.println(service.getAllStudent());
    }
}
