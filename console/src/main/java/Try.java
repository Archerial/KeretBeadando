import uni.eszterhazy.beadando.dao.StudentDAO;
import uni.eszterhazy.beadando.dao.relational.StudentDAORelation;
import uni.eszterhazy.beadando.model.Department;
import uni.eszterhazy.beadando.model.Student;
import uni.eszterhazy.beadando.service.StudentsService;
import uni.eszterhazy.beadando.service.impl.StudentServiceImpl;

public class Try {
    public static void main(String[] args) {
        StudentDAO sDao = new StudentDAORelation();
        StudentsService service = new StudentServiceImpl(sDao);
        System.out.println(service.getAllStudent());

    }
}
