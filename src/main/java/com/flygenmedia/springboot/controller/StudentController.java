package com.flygenmedia.springboot.controller;

import com.flygenmedia.springboot.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

//    http://localhost:8080/student
    @GetMapping("student")
    public Student getStudent(){
        Student student = new Student(
                1,
                "Vinay",
                "Mundhe"
        );
        return student;
    }

    //    http://localhost:8080/students
    @GetMapping("students")
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"Vinay","Mundhe"));
        students.add(new Student(2,"Tom","Cruise"));
        students.add(new Student(3, "Shah Rukh", "Khan"));
        students.add(new Student(4, "Cristiano", "Ronaldo"));
        return students;
    }

//    Spring Boot REST API with Path Variable
//    {id} - URI Template Variable
//    http://localhost:8080/students/1/ramesh/pawar
    @GetMapping("students/{id}/{first-name}/{last-name}")
    public Student studentPathVariable(@PathVariable("id") int studentId,
                                       @PathVariable("first-name") String firstName,
                                       @PathVariable("last-name") String lastName){
        return new Student(studentId, firstName, lastName);
    }

//    Spring boot REST API with Request Param
//    http://localhost:8080/students/query?id=1&firstName=ShahRukh&lastName=Khan
    @GetMapping("students/query")
    public Student studentRequestVariable(@RequestParam int id,
                                          @RequestParam String firstName,
                                          @RequestParam String lastName){
        return new Student(id, firstName, lastName);
    }

//    Spring boot REST API that handles HTTP POST Request
//    http://localhost:8080/students/create
    @PostMapping("students/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }
}
