package uni.eszterhazy.beadando.dao.relational;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import uni.eszterhazy.beadando.dao.StudentDAO;
import uni.eszterhazy.beadando.exceptions.*;
import uni.eszterhazy.beadando.model.Department;
import uni.eszterhazy.beadando.model.LanguageKnowledge;
import uni.eszterhazy.beadando.model.Student;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public class StudentDAORelation implements StudentDAO {
    private static SessionFactory factory;

    public StudentDAORelation() {
        factory = new Configuration().configure().buildSessionFactory();
    }

    /*
    *
    * if (student.getId().length() != 6){
            throw new InvalidParams(student.getId());
        }
    *
    * */


    public void createStudent(Student student) throws StudentNotFound {
        try{
            readStudent(student.getId());
        } catch (StudentNotFound e) {
            Session session = factory.openSession();
            Transaction trans = session.beginTransaction();
            session.save(student);
            trans.commit();
            session.close();
            return;
        }
        throw new StudentNotFound(student.getId());

    }

    public Collection<Student> readAllStudent() {
        Session session = factory.openSession();
        Collection<Student> result = session.createQuery("FROM Student").list();
        return result;
    }

    @Override
    public Student readStudent(String id) throws StudentNotFound{
        Session session = factory.openSession();
        if (session.get(Student.class,id)== null){
            throw new StudentNotFound(id);
        }
        Student result = session.get(Student.class,id);
        return result;
    }

    @Override
    public void updateStudent(String name, String id, LocalDate birth_date, Department department, int passed_semesters, List<LanguageKnowledge> languageKnowledge) throws NameCannotBeEmpty, IncorrectNeptunCode, TheStudentIsTooYoung, TheStudentIsTooOld, StudentNotFound {
        Session session=factory.openSession();
        if (session.get(Student.class,id)== null){
            throw new StudentNotFound(id);
        }
        Transaction tx=session.beginTransaction();
        Student object=session.get(Student.class,id);
        object.setName(name);
        object.setId(id);
        object.setBirth_date(birth_date);
        object.setDepartment(department);
        object.setPassed_semesters(passed_semesters);
        object.setLanguageKnowledge(languageKnowledge);
        session.update(object);
        tx.commit();
        session.close();
    }

    public void removeStudent(String id) throws StudentNotFound{
        Session session=factory.openSession();
        if (session.get(Student.class,id)== null){
            throw new StudentNotFound(id);
        }
        Transaction tx=session.beginTransaction();
        Student obj = session.get( Student.class,id);
        session.delete(obj);
        tx.commit();
        session.close();
    }

    public Collection<Student> readAllStudentOfDepartment(Department department) {
        Session session = factory.openSession();
        String hql = "From Student Where department = :department";
        Query q = session.createQuery(hql);
        q.setParameter("department",department);
        Collection result = q.list();
        return result;
    }
}
