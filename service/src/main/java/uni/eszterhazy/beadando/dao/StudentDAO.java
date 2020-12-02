package uni.eszterhazy.beadando.dao;

import org.springframework.format.annotation.DateTimeFormat;
import uni.eszterhazy.beadando.exceptions.*;
import uni.eszterhazy.beadando.model.Department;
import uni.eszterhazy.beadando.model.LanguageKnowledge;
import uni.eszterhazy.beadando.model.Student;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public interface StudentDAO {
    void createStudent(Student student) throws IOException, InvalidParams, StudentNotFound;
    Collection<Student> readAllStudent();
    Student readStudent(String id) throws StudentNotFound;
    void updateStudent(String name, String id, LocalDate birth_date, Department department, int passed_semesters, List<LanguageKnowledge> languageKnowledge) throws NameCannotBeEmpty, IncorrectNeptunCode, TheStudentIsTooYoung, TheStudentIsTooOld, StudentNotFound;
    void removeStudent(String id) throws StudentNotFound;
    Collection<Student> readAllStudentOfDepartment(Department department);
}
