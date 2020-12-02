package uni.eszterhazy.beadando.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import uni.eszterhazy.beadando.exceptions.InvalidParams;
import uni.eszterhazy.beadando.exceptions.StudentNotFound;
import uni.eszterhazy.beadando.model.Department;
import uni.eszterhazy.beadando.model.Student;
import uni.eszterhazy.beadando.service.StudentsService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.IOException;
import java.util.Collection;

@RestController
@RequestMapping(value = "/rest/")
public class RESTStudentController {

    @Autowired
    StudentsService studentsService;

    /*
    @GetMapping(value = "students")
    public Collection<Student> getAllStudent(){
        return studentsService.getAllStudent();
    }*/

    @GetMapping(value = "students/{id:[A-Za-z0-9]{6}}")
    public Student getStudentById(@PathVariable(name = "id") String id) throws StudentNotFound {
        try {
            return studentsService.getStudentById(id);}
        catch (StudentNotFound e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Student with the following ID isn't avaliable: "+e.getMessage(), e);
        }
    }
    /*
    @ExceptionHandler(StudentNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String unknownStudentId(StudentNotFound e){
        return "Student with the following ID isn't avaliable: "+e.getMessage();
    }*/

    @GetMapping(value = "students")
    public Collection<Student> getAllStudentOfDepartment(@RequestParam(value = "department", required = false) Department department){
        if (department != null){
            return studentsService.readAllStudentOfDepartment(department);
        } return  studentsService.getAllStudent();
    }

    /*
    @PostMapping(value = "students", consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json;charset=utf-8")
    public String addStudent(@RequestBody Student student){
        System.out.println("Plus: " + student);
        //studentsService.addStudent(student);
        return "";
    }*/

    @PostMapping(value = "students", consumes = MediaType.APPLICATION_JSON_VALUE, produces="application/json;charset=utf-8")
    public String addStudent(@RequestBody Student student) throws IOException, InvalidParams, StudentNotFound {
        try{
            System.out.println("Plus: "+student);
            studentsService.addStudent(student);
            return "A new student has been added, with the following neptun code:  "+student.getId();
        } catch (StudentNotFound e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Student with the following ID already in use: "+e.getMessage(), e);
        }

    }







}
