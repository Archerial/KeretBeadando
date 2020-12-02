package uni.eszterhazy.beadando.service.impl;

import org.apache.log4j.Logger;
import org.springframework.format.annotation.DateTimeFormat;
import uni.eszterhazy.beadando.dao.StudentDAO;
import uni.eszterhazy.beadando.exceptions.*;
import uni.eszterhazy.beadando.model.Department;
import uni.eszterhazy.beadando.model.LanguageKnowledge;
import uni.eszterhazy.beadando.model.Student;
import uni.eszterhazy.beadando.service.StudentsService;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class StudentServiceImpl implements StudentsService {
    Logger logger = Logger.getLogger(this.getClass());
    private StudentDAO sDao;

    public StudentServiceImpl(StudentDAO sDao) {
        this.sDao = sDao;
    }

    public void addStudent(Student student) throws IOException, InvalidParams, StudentNotFound {
        sDao.createStudent(student);
    }

    public Collection<Student> getAllStudent() {
        Collection<Student> result = sDao.readAllStudent();
        logger.info("The database contains " + result.size() + " student(s)");
        return sDao.readAllStudent();
    }

    @Override
    public Student getStudentById(String id)  throws StudentNotFound {
        return sDao.readStudent(id);
    }



    public void updateStudent(String name, String id, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate birth_date, Department department, int passed_semesters, List<LanguageKnowledge> languageKnowledge) throws TheStudentIsTooOld, NameCannotBeEmpty, TheStudentIsTooYoung, IncorrectNeptunCode, StudentNotFound {
        sDao.updateStudent(name,id,birth_date,department,passed_semesters,languageKnowledge);
    }

    public void deleteStudent(String id)  throws StudentNotFound {
        sDao.removeStudent(id);
    }

    /*
    public Collection<Student> readAllStudentOfDepartment(Department department) {
        Collection<Student> students = getAllStudent();
        students.stream().filter(s -> s.getDepartment() == department).collect(Collectors.toList());
        return sDao.readAllStudentOfDepartment(department);
    }*/

    public Collection<Student> readAllStudentOfDepartment(Department department) {
        Collection<Student> students = getAllStudent();
        Collection<Student> result = students.stream().filter(s -> s.getDepartment() == department).collect(Collectors.toList());
        return result;
    }

}
